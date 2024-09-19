package com.sayan.FirstJob.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long id);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);

}
