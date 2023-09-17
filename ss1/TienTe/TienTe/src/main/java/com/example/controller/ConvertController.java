package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ConvertController {
    @RequestMapping(value = {"/display"," "} , method = RequestMethod.GET)
    public String showConvert(){
        return "display";
    }
    @RequestMapping(value = "/convert" , method = RequestMethod.POST)
    public String convert(@RequestParam long vnd, Model model){
        long usd = vnd * 23000;
        model.addAttribute("usd",usd);
        return "display";
    }
}
