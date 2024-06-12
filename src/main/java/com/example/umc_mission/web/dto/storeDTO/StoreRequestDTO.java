package com.example.umc_mission.web.dto.storeDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinStoreDTO{
        @NotNull
        String name;
        @NotNull
        String address;
    }
}
