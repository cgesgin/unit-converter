package com.cgesgin.unit_converter.model;

import com.cgesgin.unit_converter.model.enums.WeightUnit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weight {
    private Double value;
    private WeightUnit fromUnit;
    private WeightUnit toUnit;
}
