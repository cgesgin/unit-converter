package com.cgesgin.unit_converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.cgesgin.unit_converter.model.Temperature;
import com.cgesgin.unit_converter.model.enums.TemperatureUnit;
import com.cgesgin.unit_converter.service.TemperatureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @GetMapping("/temperature")
    public String getMethodName(Model model) {
        
        model.addAttribute("temperature", new Temperature());
        model.addAttribute("units", TemperatureUnit.values());

        return "temperature/temperature-page";
    }

    @PostMapping("/temperature")
    public String postMethodName(Model model,Temperature temperature) {

        Double dataResult = temperatureService.convert(temperature);

        Temperature newTemperature = new Temperature();

        newTemperature.setFromUnit(temperature.getFromUnit());
        newTemperature.setToUnit(temperature.getToUnit());
        newTemperature.setValue(dataResult);
        
        model.addAttribute("result",newTemperature);
        model.addAttribute("oldvalue", temperature.getValue());

        return "temperature/temperature-result";
    }
    
    
    
}
