package com.cgesgin.unit_converter.service;

import org.springframework.stereotype.Service;

import com.cgesgin.unit_converter.model.Weight;
import com.cgesgin.unit_converter.model.enums.WeightUnit;

@Service
public class WeightService {
    
    public Double convert(Weight weight) {
        double result = 0.0;
        WeightUnit fromUnit = weight.getFromUnit();
        WeightUnit toUnit = weight.getToUnit();
        double value = weight.getValue();

        double grams = convertToGrams(value, fromUnit);

        result = convertFromGrams(grams, toUnit);

        return result;
    }

    private double convertToGrams(double value, WeightUnit fromUnit) {
        switch (fromUnit) {
            case MILLIGRAM:
                return value * 0.001;
            case GRAM:
                return value;
            case KILOGRAM:
                return value * 1000;
            case OUNCE:
                return value * 28.3495;
            case POUND:
                return value * 453.592;
            default:
                return value;
        }
    }
    
    private double convertFromGrams(double grams, WeightUnit toUnit) {
        switch (toUnit) {
            case MILLIGRAM:
                return grams / 0.001;
            case GRAM:
                return grams;
            case KILOGRAM:
                return grams / 1000;
            case OUNCE:
                return grams / 28.3495;
            case POUND:
                return grams / 453.592;
            default:
                return grams;
        }
    }
}
