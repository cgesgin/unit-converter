package com.cgesgin.unit_converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cgesgin.unit_converter.model.Weight;
import com.cgesgin.unit_converter.model.enums.WeightUnit;
import com.cgesgin.unit_converter.service.WeightService;


@Controller
public class WeightController {

    @Autowired
    private WeightService weightService;
    
    @GetMapping("/weight")
    public String returnResult(Model model) {

        model.addAttribute("weight", new Weight());
        model.addAttribute("units", WeightUnit.values());

        return "weight/weight-page";
    }

    @PostMapping("/weight")
    public String submitForm(Weight weight, Model model ,BindingResult bindingResult) {

        Double dataResult = weightService.convert(weight);

        Weight newlWWeight = new Weight();

        newlWWeight.setFromUnit(weight.getFromUnit());
        newlWWeight.setToUnit(weight.getToUnit());
        newlWWeight.setValue(dataResult);
        
        model.addAttribute("result",newlWWeight);
        model.addAttribute("oldvalue", weight.getValue());
        return "weight/weight-result";
    }   
}