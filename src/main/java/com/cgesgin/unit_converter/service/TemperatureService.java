package com.cgesgin.unit_converter.service;

import org.springframework.stereotype.Service;

import com.cgesgin.unit_converter.model.Temperature;
import com.cgesgin.unit_converter.model.enums.TemperatureUnit;

@Service
public class TemperatureService {

    public Double convert(Temperature temperature) {
        double result = 0.0;
        TemperatureUnit fromUnit = temperature.getFromUnit();
        TemperatureUnit toUnit = temperature.getToUnit();
        double value = temperature.getValue();

        double meters = convertToCelsius(value, fromUnit);

        result = convertFromCelsius(meters, toUnit);

        return result;
    }

    private double convertToCelsius(double temperature, TemperatureUnit fromUnit) {
        switch (fromUnit) {
            case CELSIUS:
                return temperature;
            case FAHRENHEIT:
                return (temperature - 32) * 5.0 / 9.0; 
            case KELVIN:
                return temperature - 273.15;
            default:
                return temperature;
        }
    }
    
    private double convertFromCelsius(double celsius, TemperatureUnit toUnit) {
        switch (toUnit) {
            case CELSIUS:
                return celsius;
            case FAHRENHEIT:
                return (celsius * 9.0 / 5.0) + 32;
            case KELVIN:
                return celsius + 273.15;
            default:
                return celsius;
        }
    }
}
