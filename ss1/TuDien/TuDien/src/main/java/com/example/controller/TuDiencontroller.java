package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TuDiencontroller {
    @RequestMapping(value = "/display" , method = RequestMethod.GET)
    public String show(){
        return  "display";
    }
    @RequestMapping(value = "dich" , method = RequestMethod.POST)
    public String showDich(@RequestParam String anh, Model model){
        String[] mangAnh = {"hello","bye","say","love"};
        String[] mangviet = {"chào","tạm biệt","nói","yêu"};
        int ktr = 0;
        int vtr = 0;
        for (int i = 0; i < mangAnh.length; i++) {
            if(mangAnh[i].equals(anh)){
                vtr = i;
                ktr++;
                break;
            }
        }
        if(ktr != 0){
            model.addAttribute("viet",mangviet[vtr]);
        }else{
            model.addAttribute("viet","không tìm thấy");
        }
        return "display";
    }
}
