package net.webprogex.springboot.repository;

import net.webprogex.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // all crud database Methods

}
