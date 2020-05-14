package com.submax.vlsmcalculator.controller;

import com.submax.vlsmcalculator.model.HostGroup;
import com.submax.vlsmcalculator.model.IP;
import com.submax.vlsmcalculator.model.IPAllocationRequest;
import com.submax.vlsmcalculator.service.VLSMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vlsm-calculator")
public class VLSMController {
    private VLSMService vlsmService;

    public VLSMController(VLSMService vlsmService){
        this.vlsmService = vlsmService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Welcome to VLSM Calculator!";
    }

    @PostMapping("/allocation")
    public ResponseEntity<List<HostGroup>> allocate(@RequestBody IPAllocationRequest request){
        try {
            return ResponseEntity.ok(vlsmService.allocate(request));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
