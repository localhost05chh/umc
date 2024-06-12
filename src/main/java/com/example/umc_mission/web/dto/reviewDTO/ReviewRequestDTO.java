package com.example.umc_mission.web.dto.reviewDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDTO{
        @NotNull
        String title;
        @NotNull
        String body;
        @NotNull
        Float score;
    }
}
