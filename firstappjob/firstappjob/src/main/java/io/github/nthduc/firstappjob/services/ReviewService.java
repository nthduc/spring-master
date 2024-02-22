package io.github.nthduc.firstappjob.services;

import io.github.nthduc.firstappjob.models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId,Long reviewId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}