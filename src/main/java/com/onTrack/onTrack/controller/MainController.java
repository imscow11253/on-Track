package com.onTrack.onTrack.controller;

import com.onTrack.onTrack.dto.GetSaleRatioResponse;
import com.onTrack.onTrack.dto.SaveDataRequest;
import com.onTrack.onTrack.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/on-track")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @PostMapping("/save")
    public String saveData(@Validated @RequestBody SaveDataRequest saveDataRequest, BindingResult bindingResult){
        log.info("MainController.saveData");

        if(bindingResult.hasErrors()){
            return "잘못된 형식";
        }
        return mainService.saveData(saveDataRequest);
    }

    @PostMapping("/client")
    public GetSaleRatioResponse getSaleRatio(@Validated @RequestBody SaveDataRequest saveDataRequest, BindingResult bindingResult){
        log.info("MainController.getSaleRatio");

        if(bindingResult.hasErrors()){
            throw new RuntimeException("잘못된 형식");
        }
        return mainService.getSaleRatio(saveDataRequest);
    }
}
