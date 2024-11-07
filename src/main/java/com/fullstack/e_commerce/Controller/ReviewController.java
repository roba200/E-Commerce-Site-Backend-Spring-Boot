package com.fullstack.e_commerce.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.e_commerce.Entity.Review;
import com.fullstack.e_commerce.Service.ReviewServidce;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    
    @Autowired
    private ReviewServidce reviewService;

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        reviewService.addReview(review.getProductId(), review.getUserId(), review.getComment(), review.getRating(), review.getTitle());
        return ResponseEntity.ok("Review added successfully");
    }

}
