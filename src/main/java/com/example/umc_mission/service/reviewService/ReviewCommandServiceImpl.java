package com.example.umc_mission.service.reviewService;

import com.example.umc_mission.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission.apiPayload.exception.GeneralException;
import com.example.umc_mission.converter.ReviewConverter;
import com.example.umc_mission.domain.Member;
import com.example.umc_mission.domain.Review;
import com.example.umc_mission.domain.Store;
import com.example.umc_mission.repository.MemberRepository;
import com.example.umc_mission.repository.ReviewRepository;
import com.example.umc_mission.repository.StoreRepository;
import com.example.umc_mission.web.dto.reviewDTO.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDTO request, Long storeId, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new GeneralException(ErrorStatus.STORE_ID_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, store, member);

        return reviewRepository.save(newReview);
    }

}
