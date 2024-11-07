package com.fullstack.e_commerce.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.e_commerce.Entity.Product;
import com.fullstack.e_commerce.Repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public void updateProduct(Long productId, String name, String description, BigDecimal price,
            Integer quantityInStock, String imageUrl1, String imageUrl2, String imageUrl3, String imageUrl4,
            String imageUrl5, Float rating, String category) {
        productRepository.findById(productId)
                .ifPresentOrElse(product -> {
                    if (name != null) {
                        product.setName(name);
                    }
                    if (description != null) {
                        product.setDescription(description);
                    }
                    if (price != null) {
                        product.setPrice(price);
                    }
                    if (quantityInStock != null) {
                        product.setQuantityInStock(quantityInStock);
                    }
                    if (imageUrl1 != null) {
                        product.setImageUrl1(imageUrl1);
                    }
                    if (imageUrl2 != null) {
                        product.setImageUrl2(imageUrl2);
                    }
                    if (imageUrl3 != null) {
                        product.setImageUrl3(imageUrl3);
                    }
                    if (imageUrl4 != null) {
                        product.setImageUrl4(imageUrl4);
                    }
                    if (imageUrl5 != null) {
                        product.setImageUrl5(imageUrl5);
                    }
                    if (rating != null) {
                        product.setRating(rating);
                    }
                    if (category != null) {
                        product.setCategory(category);

                    }

                    productRepository.save(product);
                }, () -> {
                    throw new RuntimeException("Product not found");
                });
    }

    public void addProduct(String name, String description, BigDecimal price, Integer quantityInStock, String imageUrl1,
            String imageUrl2, String imageUrl3, String imageUrl4, String imageUrl5, Float rating, String category) {
        productRepository
                .save(new Product(null, name, description, price, quantityInStock, category, imageUrl1, imageUrl2,
                        imageUrl3, imageUrl4, imageUrl5, rating));
    }

}
