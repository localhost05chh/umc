package com.example.umc_mission.repository;

import com.example.umc_mission.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionCategoryRepository extends JpaRepository<MemberMission, Long> {
}
