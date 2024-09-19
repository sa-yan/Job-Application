package com.sayan.FirstJob.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),
                HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,
                                            @RequestBody Review review){
        if(reviewService.addReview(companyId, review)){
            reviewService.addReview(companyId, review);
            return new ResponseEntity<>("Review Added Sucessfully",
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not saved",
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                            @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId)
                ,HttpStatus.OK );
    }

    //TODO: ENABLE UPDATE, DELETE REVIEW FUNCTIONALITY
}
