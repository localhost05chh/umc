package com.example.umc_mission.service.reviewService;

import com.example.umc_mission.domain.Review;
import com.example.umc_mission.web.dto.reviewDTO.ReviewRequestDTO;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewCommandService {
    @Transactional
    Review createReview(ReviewRequestDTO.CreateDTO request, Long storeId, Long memberId);
}
