package com.example.umc_mission.service.memberService;

import com.example.umc_mission.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission.apiPayload.exception.GeneralException;
import com.example.umc_mission.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc_mission.converter.MemberConverter;
import com.example.umc_mission.converter.MemberMissionConverter;
import com.example.umc_mission.converter.MemberPreferConverter;
import com.example.umc_mission.converter.ReviewConverter;
import com.example.umc_mission.domain.*;
import com.example.umc_mission.domain.mapping.MemberMission;
import com.example.umc_mission.domain.mapping.MemberPrefer;
import com.example.umc_mission.repository.*;
import com.example.umc_mission.web.dto.memberDTO.MemberRequestDTO;
import com.example.umc_mission.web.dto.reviewDTO.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    private final MemberMissionCategoryRepository memberMissionCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDTO request, Long storeId, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new GeneralException(ErrorStatus.STORE_ID_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, store, member);

        return reviewRepository.save(newReview);
    }

    @Override
    @Transactional
    public MemberMission createMission(Long missionId, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission newChallenge = MemberMissionConverter.toMemberMission(mission, member);

        return memberMissionCategoryRepository.save(newChallenge);
    }

}
