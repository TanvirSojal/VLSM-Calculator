package com.submax.vlsmcalculator.service;

import com.submax.vlsmcalculator.algorithm.SubnetCalculator;
import com.submax.vlsmcalculator.exception.IPSpaceException;
import com.submax.vlsmcalculator.model.HostGroup;
import com.submax.vlsmcalculator.model.IPAllocationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VLSMService {
    public List<HostGroup> allocate(IPAllocationRequest request) throws IPSpaceException {
        return SubnetCalculator.allocate(request);
    }
}
