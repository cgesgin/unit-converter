package com.cgesgin.unit_converter.service;

import org.springframework.stereotype.Service;

import com.cgesgin.unit_converter.model.Length;
import com.cgesgin.unit_converter.model.enums.LengthUnit;

@Service
public class LengthService {
    
    public Double convert(Length length) {
        double result = 0.0;
        LengthUnit fromUnit = length.getFromUnit();
        LengthUnit toUnit = length.getToUnit();
        double value = length.getValue();

        double meters = convertToMeters(value, fromUnit);

        result = convertFromMeters(meters, toUnit);

        return result;
    }

    private double convertToMeters(double value, LengthUnit fromUnit) {
        switch (fromUnit) {
            case MILLIMETER:
                return value * 0.001;
            case CENTIMETER:
                return value * 0.01;
            case METER:
                return value;
            case KILOMETER:
                return value * 1000;
            case INCH:
                return value * 0.0254;
            case FOOT:
                return value * 0.3048;
            case YARD:
                return value * 0.9144;
            case MILE:
                return value * 1609.344;
            default:
                return value;
        }
    }

    private double convertFromMeters(double meters, LengthUnit toUnit) {
        switch (toUnit) {
            case MILLIMETER:
                return meters / 0.001;
            case CENTIMETER:
                return meters / 0.01;
            case METER:
                return meters;
            case KILOMETER:
                return meters / 1000;
            case INCH:
                return meters / 0.0254;
            case FOOT:
                return meters / 0.3048;
            case YARD:
                return meters / 0.9144;
            case MILE:
                return meters / 1609.344;
            default:
                return meters;
        }
    }
}
