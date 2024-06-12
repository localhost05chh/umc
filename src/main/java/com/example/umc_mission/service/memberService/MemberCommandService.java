package com.example.umc_mission.service.memberService;

import com.example.umc_mission.domain.Member;
import com.example.umc_mission.domain.Review;
import com.example.umc_mission.domain.mapping.MemberMission;
import com.example.umc_mission.web.dto.memberDTO.MemberRequestDTO;
import com.example.umc_mission.web.dto.reviewDTO.ReviewRequestDTO;
import org.springframework.transaction.annotation.Transactional;


public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);

    @Transactional
    Review createReview(ReviewRequestDTO.CreateDTO request, Long storeId, Long memberId);

    @Transactional
    MemberMission createMission(Long missionId, Long memberId);
}
