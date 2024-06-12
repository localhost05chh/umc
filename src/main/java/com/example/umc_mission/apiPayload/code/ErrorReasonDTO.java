package com.example.umc_mission.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReasonDTO {
    private HttpStatus httpStatus;

    private final boolean isSuccess;
    private final String code;
    private final String message;
}