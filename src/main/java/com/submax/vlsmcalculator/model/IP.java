package com.submax.vlsmcalculator.model;

import com.submax.vlsmcalculator.algorithm.IPUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IP {
    protected long addressValue;
    protected String addressNotation;
    protected int cidr;

    public IP(long addressValue){
        this.addressValue = addressValue;
        this.cidr = 0;
        this.addressNotation = IPUtil.getIPNotation(this.addressValue, this.cidr);
    }

    public IP(long addressValue, int cidr){
        this.addressValue = addressValue;
        this.cidr = cidr;
        this.addressNotation = IPUtil.getIPNotation(this.addressValue, this.cidr);
    }

    public String toString(){
        return getAddressNotation();
    }
}
