package com.example.umc_mission.service.storeService;

import com.example.umc_mission.domain.Store;
import com.example.umc_mission.web.dto.storeDTO.StoreRequestDTO;

public interface StoreService {
    Store joinStore(StoreRequestDTO.JoinStoreDTO request, Long regionId);
}
