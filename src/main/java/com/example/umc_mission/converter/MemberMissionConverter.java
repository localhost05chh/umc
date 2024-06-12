package com.example.umc_mission.converter;

import com.example.umc_mission.domain.Member;
import com.example.umc_mission.domain.Mission;
import com.example.umc_mission.domain.mapping.MemberMission;
import com.example.umc_mission.web.dto.memberDTO.MemberMissionResponseDTO;


import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.ChallengeResultDTO toMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(Mission mission, Member member){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();


    }
}
