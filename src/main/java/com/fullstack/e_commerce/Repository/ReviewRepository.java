package com.fullstack.e_commerce.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fullstack.e_commerce.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    
} 
