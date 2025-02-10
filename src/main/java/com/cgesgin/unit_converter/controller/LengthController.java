package com.cgesgin.unit_converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cgesgin.unit_converter.model.Length;
import com.cgesgin.unit_converter.model.enums.LengthUnit;
import com.cgesgin.unit_converter.service.LengthService;


@Controller
public class LengthController {

    @Autowired
    private LengthService lengthService;
    
    @GetMapping("/")
    public String returnResult(Model model) {

        model.addAttribute("length", new Length());
        model.addAttribute("units", LengthUnit.values());

        return "length/length-page";
    }

    @PostMapping("/")
    public String submitForm(Length length, Model model ,BindingResult bindingResult) {

        Double dataResult = lengthService.convert(length);

        Length newlLength = new Length();

        newlLength.setFromUnit(length.getFromUnit());
        newlLength.setToUnit(length.getToUnit());
        newlLength.setValue(dataResult);
        
        model.addAttribute("result",newlLength);
        model.addAttribute("oldvalue", length.getValue());
        return "length/length-result";
    }   
}