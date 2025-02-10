package com.cgesgin.unit_converter.model;

import com.cgesgin.unit_converter.model.enums.TemperatureUnit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Temperature {
    private Double value;
    private TemperatureUnit fromUnit;
    private TemperatureUnit toUnit;
}