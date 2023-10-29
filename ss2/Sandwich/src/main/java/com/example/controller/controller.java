package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {
    @GetMapping(value = "/")
    public String show(){
        return "display";
    }
    @PostMapping(value = "save")
    public String showSave(@RequestParam String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "save";
    }
}
