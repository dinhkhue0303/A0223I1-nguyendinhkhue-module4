package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class controller {
    @GetMapping(value = "/")
    public String cal(){
        return "display";
    }

    @PostMapping(value = "cal")
    public String result(@RequestParam String button,
                         @RequestParam String number1,@RequestParam String number2,
                         Model model){

        Map<String, String> map = this.ktr(number1,number2);
        if(map.isEmpty()) {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            double result = 0;
            switch (button) {
                case "add":
                    result = num1 + num2;
                    break;
                case "sub":
                    result = num1 - num2;
                    break;
                case "mul":
                    result = num1 * num2;
                    break;
                case "div":
                    result = num1 / num2;
                    break;
            }
            model.addAttribute("result", result);
            return "display";
        }else {
            model.addAttribute("map",map);
            model.addAttribute("number1",number1);
            model.addAttribute("number2",number2);
            return "display";
        }
    }
    public Map<String,String> ktr(String number1, String number2){
        Map<String,String> map = new HashMap<>();
        if(number1.equals("")){
            map.put("num1","không đc bỏ trống");
        }else if(!number1.matches("-?\\d+")){
            map.put("num1","nhập sai định dạng");
        }
        if(number2.equals("")){
            map.put("num2","không đc bỏ trống");
        }else if(!number2.matches("-?\\d+")){
            map.put("num2","nhập sai định dạng");
        }else if(number2.equals("0")){
            map.put("num2","không thể nhập 0");
        }
        return map;
    }
}
