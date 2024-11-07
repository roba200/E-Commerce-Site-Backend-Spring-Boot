package com.fullstack.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.e_commerce.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}

