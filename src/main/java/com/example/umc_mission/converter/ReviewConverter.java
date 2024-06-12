package com.example.umc_mission.converter;

import com.example.umc_mission.domain.Member;
import com.example.umc_mission.domain.Review;
import com.example.umc_mission.domain.Store;
import com.example.umc_mission.web.dto.reviewDTO.ReviewRequestDTO;
import com.example.umc_mission.web.dto.reviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review) {

        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDTO request, Store store, Member member){

        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .store(store)
                .member(member)
                .build();
    }
}
