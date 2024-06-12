package com.example.umc_mission.service.storeService;

import com.example.umc_mission.apiPayload.code.status.ErrorStatus;
import com.example.umc_mission.apiPayload.exception.GeneralException;
import com.example.umc_mission.converter.StoreConverter;
import com.example.umc_mission.domain.Region;
import com.example.umc_mission.domain.Store;
import com.example.umc_mission.repository.RegionRepository;
import com.example.umc_mission.repository.StoreRepository;
import com.example.umc_mission.web.dto.storeDTO.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinStoreDTO request, Long regionId){

        Region region = regionRepository.findById(regionId).orElseThrow(() -> new GeneralException(ErrorStatus.REGION_ID_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, region);


        return storeRepository.save(newStore);
    }

}
