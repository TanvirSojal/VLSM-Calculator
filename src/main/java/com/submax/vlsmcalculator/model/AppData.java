package com.submax.vlsmcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppData {
    private String app; // the app the analytics is for
    private long useCount;
}