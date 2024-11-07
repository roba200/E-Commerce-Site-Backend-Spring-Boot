package com.fullstack.e_commerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullstack.e_commerce.Service.ProductService;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(
            @PathVariable Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) Integer quantityInStock,
            @RequestParam(required = false) String imageUrl1,
            @RequestParam(required = false) String imageUrl2,
            @RequestParam(required = false) String imageUrl3,
            @RequestParam(required = false) String imageUrl4,
            @RequestParam(required = false) String imageUrl5,
            @RequestParam(required = false) Float rating,
            @RequestParam(required = false) String category) {

        try {
            productService.updateProduct(productId, name, description, price, quantityInStock, imageUrl1, imageUrl2, imageUrl3, imageUrl4, imageUrl5, rating ,category);
            return ResponseEntity.ok("Product updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Product not found");
        }
    }
    @PostMapping
    public ResponseEntity<String> addProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam BigDecimal price,
            @RequestParam Integer quantityInStock,
            @RequestParam String imageUrl1,
            @RequestParam String imageUrl2,
            @RequestParam String imageUrl3,
            @RequestParam String imageUrl4,
            @RequestParam String imageUrl5,
            @RequestParam Float rating,
            @RequestParam String category) {

        productService.addProduct(name, description, price, quantityInStock, imageUrl1, imageUrl2, imageUrl3, imageUrl4, imageUrl5, rating, category);
        return ResponseEntity.ok("Product added successfully");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProduct(productId);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Product not found");
        }
    }
    
}
