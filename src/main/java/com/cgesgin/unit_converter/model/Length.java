package com.cgesgin.unit_converter.model;

import com.cgesgin.unit_converter.model.enums.LengthUnit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Length {
    private Double value;
    private LengthUnit fromUnit;
    private LengthUnit toUnit;
}