package net.webprogex.springboot.controller;


import net.webprogex.springboot.exception.ResourceNotFoundException;
import net.webprogex.springboot.model.Product;
import net.webprogex.springboot.repository.ProductRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/products")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    //build create product REST API
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not exist with this ID:" + id));
        return ResponseEntity.ok(product);
    }

    //build update employee by REST API
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product productDetails){
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not exist."));

    updateProduct.setProductName(productDetails.getProductName());
    updateProduct.setProductPrice(productDetails.getProductPrice());
    updateProduct.setProductType(productDetails.getProductType());

    productRepository.save(updateProduct);

    return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exists"));

        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}