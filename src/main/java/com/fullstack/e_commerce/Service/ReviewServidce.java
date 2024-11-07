package com.fullstack.e_commerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.e_commerce.Entity.Review;
import com.fullstack.e_commerce.Repository.ReviewRepository;

@Service
public class ReviewServidce {
    @Autowired
    private ReviewRepository reviewRepository;

    public void addReview(Long productId, Long userId, String comment,Float rating, String title) {
        reviewRepository.save(Review.builder()
                .productId(productId)
                .userId(userId)
                .comment(comment)
                .rating(rating).title(title).build());
    }

}
