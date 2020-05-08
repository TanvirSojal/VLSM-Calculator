package com.submax.vlsmcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HostGroupRequest {
    private long id;
    private String name;
    @Setter
    private long size;

    public int compare(HostGroupRequest that) {
        return Long.compare(that.getSize(), this.size);
    }

    public String toString(){
        return "{ id: " + id + " : " + name + " need : " + size + " }";
    }
}
