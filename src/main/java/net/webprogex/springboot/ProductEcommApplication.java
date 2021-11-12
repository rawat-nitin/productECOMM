package net.webprogex.springboot;

import net.webprogex.springboot.model.Product;
import net.webprogex.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductEcommApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProductEcommApplication.class, args);
    }


    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception{
        // Product product = new Product();
        // product.setProductName("Jeans");
        // product.setProductType("Clothing");
        // product.setProductPrice(5000.00F);
        // productRepository.save(product);
    }
}
