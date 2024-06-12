package com.example.umc_mission.converter;

import com.example.umc_mission.domain.Region;
import com.example.umc_mission.domain.Store;
import com.example.umc_mission.web.dto.storeDTO.StoreRequestDTO;
import com.example.umc_mission.web.dto.storeDTO.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.JoinStoreResultDTO toStoreResultDTO(Store store) {
        return StoreResponseDTO.JoinStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinStoreDTO request, Region region){

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
