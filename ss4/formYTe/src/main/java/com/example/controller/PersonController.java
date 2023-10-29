package com.example.controller;

import com.example.model.Person;
import com.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    IPersonService iPersonService;
    @GetMapping("")
    public String showCreate(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("gioiTinh", new String[]{"nam","nữ"});
        model.addAttribute("quocTia", new String[]{"việt nam","mỹ","nhật","anh"});
        model.addAttribute("tinhThanh", new String[]{"đà nẵng","hà nội"});
        model.addAttribute("quanHuyen",new String[]{"hải châu","thanh khê"});
        model.addAttribute("phuongXa",new String[]{"hòa khê","hòa khê 2"});
        return "toKhaiYTe";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Person person, RedirectAttributes redirectAttributes){
        iPersonService.create(person);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/";
    }
    @GetMapping("/list")
    public ModelAndView showList(){
        List<Person> Plist = iPersonService.display();
        ModelAndView modelAndView = new ModelAndView("list","Plist",Plist);
        return modelAndView;
    }
    @GetMapping("/update/{CMND}")
    public String showUpdate(@PathVariable String CMND, Model model){
        Person person = iPersonService.findCMND(CMND);
        model.addAttribute("person", person);
        return "update";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute Person person, RedirectAttributes redirectAttributes){
        iPersonService.update(person.getCMND(),person);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/";
    }
}
