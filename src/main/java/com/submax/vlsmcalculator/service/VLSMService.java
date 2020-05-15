package com.submax.vlsmcalculator.service;

import com.submax.vlsmcalculator.algorithm.SubnetCalculator;
import com.submax.vlsmcalculator.exception.IPSpaceException;
import com.submax.vlsmcalculator.model.HostGroup;
import com.submax.vlsmcalculator.model.IPAllocationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VLSMService {
    private AnalyticsService analyticsService;

    public VLSMService(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    public List<HostGroup> allocate(IPAllocationRequest request) throws IPSpaceException {
        List<HostGroup> hostGroupList =  SubnetCalculator.allocate(request);
        analyticsService.incrementUseCount(); // asynchronous call, so response to user is not delayed
        return hostGroupList;
    }
}
