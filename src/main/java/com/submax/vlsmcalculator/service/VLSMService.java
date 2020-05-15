package com.submax.vlsmcalculator.service;

import com.submax.vlsmcalculator.algorithm.SubnetCalculator;
import com.submax.vlsmcalculator.exception.IPSpaceException;
import com.submax.vlsmcalculator.model.AppData;
import com.submax.vlsmcalculator.model.HostGroup;
import com.submax.vlsmcalculator.model.IPAllocationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VLSMService {
    @Value("${analytics-url}/vlsm")
    private String analyticsURL;
    private RestTemplate restTemplate;

    public VLSMService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<HostGroup> allocate(IPAllocationRequest request) throws IPSpaceException {
        List<HostGroup> hostGroupList =  SubnetCalculator.allocate(request);
        incrementUseCount();
        return hostGroupList;
    }

    private boolean incrementUseCount(){
        System.out.println("API called!");
        try{
            System.out.println(analyticsURL + "/increment");
            AppData appData = restTemplate.getForObject(analyticsURL + "/increment", AppData.class);
            System.out.println(appData);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
