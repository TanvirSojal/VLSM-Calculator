package com.submax.vlsmcalculator.service;

import com.submax.vlsmcalculator.model.AppData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AnalyticsService {
    @Value("${analytics-url}/vlsm")
    private String analyticsURL;
    private RestTemplate restTemplate;

    public AnalyticsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // asynchronous call to increment use count
    public @Async
    CompletableFuture<AppData> incrementUseCount(){
        try{
            AppData appData = restTemplate.getForObject(analyticsURL + "/increment", AppData.class);
            return CompletableFuture.completedFuture(appData);
        } catch (Exception e){
            return null;
        }
    }
}
