package com.submax.vlsmcalculator.service;

import com.google.gson.Gson;
import com.submax.vlsmcalculator.exception.IPSpaceException;
import com.submax.vlsmcalculator.model.HostGroup;
import com.submax.vlsmcalculator.model.HostGroupRequest;
import com.submax.vlsmcalculator.model.IP;
import com.submax.vlsmcalculator.model.IPAllocationRequest;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VLSMServiceTest {
    @Autowired
    private VLSMService vlsmService;

    @Test
    public void ipNotationTest() {
        IP ip = new IP(783, 12);
        String notation = ip.getAddressNotation();
        String required = "0.0.3.15/12";
        assertEquals(required, notation);
    }

    @Test
    public void allocateTest() throws IPSpaceException {
        HostGroupRequest r1 = new HostGroupRequest(1, "My Home", 5);
        HostGroupRequest r2 = new HostGroupRequest(2, "My Office", 15);
        HostGroupRequest r3 = new HostGroupRequest(3, "My Garage", 23);
        HostGroupRequest r4 = new HostGroupRequest(4, "My Rooftop", 3);

        List<HostGroupRequest> requestList = new ArrayList<>();
        requestList.add(r1);
        requestList.add(r2);
        requestList.add(r3);
        requestList.add(r4);

        IP source = new IP(3422552332L, 16);
        IPAllocationRequest request = new IPAllocationRequest(source, requestList);
        Gson gson = new Gson();

        String json = gson.toJson(request);
        System.out.println(json);
        List<HostGroup> hostGroupList = vlsmService.allocate(request);
    }
}
