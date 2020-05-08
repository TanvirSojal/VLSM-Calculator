package com.submax.vlsmcalculator.model;

import com.submax.vlsmcalculator.algorithm.IPUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HostGroup {
    private long id;
    private String name;
    private IP networkAddress;
    private IP gatewayAddress;
    private IP broadcastAddress;
    private long groupSize;

    public HostGroup(long id, String name, IP networkAddress, long groupSize){
        this.id = id;
        this.name = name;
        this.networkAddress = networkAddress;
        this.gatewayAddress = IPUtil.getGatewayAddress(networkAddress);
        this.broadcastAddress = IPUtil.getBroadcastAddress(networkAddress, groupSize);
        this.groupSize = groupSize;
    }

    public int compare(HostGroup that) {
        return Long.compare(this.id, that.getId());
    }
}
