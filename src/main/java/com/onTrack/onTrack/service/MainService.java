package com.onTrack.onTrack.service;

import com.onTrack.onTrack.dto.GetSaleRatioResponse;
import com.onTrack.onTrack.dto.SaveDataRequest;
import com.onTrack.onTrack.model.Kickboard;
import com.onTrack.onTrack.repository.KickboardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final KickboardRepository kickboardRepository;

    public String saveData(SaveDataRequest saveDataRequest) {
        log.info("MainService.saveData");

        Kickboard kickboard = this.kickboardRepository.findByKickboardId(saveDataRequest.getKickboardId());

        if(kickboard == null){
            return "매칭되는 킥보드 정보가 없습니다.";
        }

        kickboard.setLatitude(saveDataRequest.getLatitude());
        kickboard.setLongitude(saveDataRequest.getLongitude());
        kickboard.setBattery(saveDataRequest.getBattery());

        kickboardRepository.save(kickboard);

        return "성공적으로 저장되었습니다.";
    }

    public GetSaleRatioResponse getSaleRatio(SaveDataRequest saveDataRequest) {
        log.info("MainService.getSaleRatio");

        Kickboard kickboard = this.kickboardRepository.findByKickboardId(saveDataRequest.getKickboardId());

        if(kickboard == null){
            throw new RuntimeException("매칭되는 킥보드 정보가 없습니다.");
        }

        Double latitude = saveDataRequest.getLatitude();
        Double longitude = saveDataRequest.getLongitude();
        List<Kickboard> kickboardList = this.kickboardRepository.findAllByLatitudeBetweenAndLongitudeBetween(latitude-0.0001, latitude+0.0001, longitude-0.0001,longitude+0.0001);
        int ratio = kickboardList.size()/5;

        return GetSaleRatioResponse.builder()
                .saleRatio(1500*(1-ratio*0.01))
                .build();

    }
}
