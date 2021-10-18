package com.scmbackend.controller;


import com.scmbackend.domain.ProductENT;
import com.scmbackend.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/scm")
@Transactional
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public List<ProductENT> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductENT getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody ProductENT productENT) throws URISyntaxException {
        ProductENT savedProduct = productRepository.save(productENT);
        return ResponseEntity.created(new URI("/product/" + savedProduct.getId())).body(savedProduct);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody ProductENT productENT) {
        ProductENT currentProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
        currentProduct = productRepository.save(productENT);
        return ResponseEntity.ok(currentProduct);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
