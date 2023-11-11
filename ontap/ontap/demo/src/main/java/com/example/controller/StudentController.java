package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
     @Autowired
     private IStudentService iStudentService;
     @ModelAttribute("className")
     public String[]getClassName(){
         return new String[]{"cc0","cc1","cc2"};
     }
     @GetMapping("")
     public ModelAndView showList(){
        List<Student> list = iStudentService.display();
        ModelAndView modelAndView = new ModelAndView("list","list",list);
        return modelAndView;
     }
     @GetMapping("/create")
     public String showCreate(Model model){
         model.addAttribute("student",new Student());
         model.addAttribute("languages", new String[]{"JS","Java","PHP"});
         return "create";
     }
     @PostMapping("/create")
     public String create(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
         iStudentService.add(student);
         redirectAttributes.addFlashAttribute("mess","created success");
         return "redirect:/student";
     }
     @GetMapping("/detail")
     public String find(@RequestParam int id,Model model){
        Student student = iStudentService.find(id);
        model.addAttribute("student",student);
        return "detail";
     }
}
