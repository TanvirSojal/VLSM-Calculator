package com.submax.vlsmcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IPAllocationRequest {
    private IP sourceNetworkAddress;
    private List<HostGroupRequest> hostGroupRequestList;
}
