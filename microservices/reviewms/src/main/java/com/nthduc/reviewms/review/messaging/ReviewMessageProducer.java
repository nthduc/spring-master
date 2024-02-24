package com.nthduc.reviewms.review.messaging;

import com.nthduc.reviewms.review.Review;
import com.nthduc.reviewms.review.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review){
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(reviewMessage.getId());
        reviewMessage.setDescription(reviewMessage.getDescription());
        reviewMessage.setRating(reviewMessage.getRating());
        reviewMessage.setCompanyId(reviewMessage.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue",reviewMessage);
    }
}
