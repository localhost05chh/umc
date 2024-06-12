package com.example.umc_mission.web.controller;

import com.example.umc_mission.apiPayload.ApiResponse;
import com.example.umc_mission.converter.MemberMissionConverter;
import com.example.umc_mission.domain.mapping.MemberMission;
import com.example.umc_mission.service.memberService.MemberCommandServiceImpl;
import com.example.umc_mission.service.missionService.MissionCommandService;
import com.example.umc_mission.service.missionService.MissionCommandServiceImpl;
import com.example.umc_mission.web.dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {


    private final MissionCommandServiceImpl missionCommandServiceImpl;

    @PostMapping("/missions/{missionId}/doing")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> doing(@PathVariable Long missionId,
                                                                    @RequestParam Long memberId){

        MemberMission newMission = missionCommandServiceImpl.createMission(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toMissionResultDTO(newMission));
    }
}
