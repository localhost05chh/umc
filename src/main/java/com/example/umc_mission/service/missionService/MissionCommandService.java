package com.example.umc_mission.service.missionService;

import com.example.umc_mission.domain.mapping.MemberMission;
import org.springframework.transaction.annotation.Transactional;

public interface MissionCommandService {
    @Transactional
    MemberMission createMission(Long missionId, Long memberId);
}
