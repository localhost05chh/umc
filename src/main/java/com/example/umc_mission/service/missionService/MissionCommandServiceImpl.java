package com.example.umc_mission.service.missionService;

import com.example.umc_mission.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission.apiPayload.exception.GeneralException;
import com.example.umc_mission.converter.MemberMissionConverter;
import com.example.umc_mission.domain.Member;
import com.example.umc_mission.domain.Mission;
import com.example.umc_mission.domain.mapping.MemberMission;
import com.example.umc_mission.repository.MemberMissionCategoryRepository;
import com.example.umc_mission.repository.MemberRepository;
import com.example.umc_mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionCategoryRepository memberMissionCategoryRepository;

    @Override
    @Transactional
    public MemberMission createMission(Long missionId, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission newChallenge = MemberMissionConverter.toMemberMission(mission, member);

        return memberMissionCategoryRepository.save(newChallenge);
    }
}
