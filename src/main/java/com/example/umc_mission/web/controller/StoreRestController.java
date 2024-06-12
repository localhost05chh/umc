package com.example.umc_mission.web.controller;

import com.example.umc_mission.apiPayload.ApiResponse;
import com.example.umc_mission.converter.ReviewConverter;
import com.example.umc_mission.converter.StoreConverter;
import com.example.umc_mission.domain.Review;
import com.example.umc_mission.domain.Store;
import com.example.umc_mission.service.memberService.MemberCommandServiceImpl;
import com.example.umc_mission.service.storeService.StoreService;
import com.example.umc_mission.web.dto.reviewDTO.ReviewRequestDTO;
import com.example.umc_mission.web.dto.reviewDTO.ReviewResponseDTO;
import com.example.umc_mission.web.dto.storeDTO.StoreRequestDTO;
import com.example.umc_mission.web.dto.storeDTO.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreService storeService;
    private final MemberCommandServiceImpl memberCommandServiceImpl;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.JoinStoreResultDTO> joinStore(@RequestParam Long regionId,
                                                                      @RequestBody StoreRequestDTO.JoinStoreDTO request) {
        Store newStore = storeService.joinStore(request, regionId);
        return ApiResponse.onSuccess(StoreConverter.toJoinStoreResultDTO(newStore));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> create(@RequestBody @Valid ReviewRequestDTO.CreateDTO request,
                                                                 @PathVariable Long storeId,
                                                                 @RequestParam Long memberId){

        Review newReview =  memberCommandServiceImpl.createReview(request, storeId, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(newReview));
    }
}
