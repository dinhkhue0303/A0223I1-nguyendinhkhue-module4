package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogRepository iBlogRepository;
    @GetMapping("")
    public ModelAndView showList(){
        List<Blog> list = iBlogRepository.display();
        ModelAndView modelAndView = new ModelAndView("display","list",list);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String Create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogRepository.save(blog);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/";
    }
    @GetMapping("/read/{id}")
    public String showRead(@PathVariable Integer id,Model model){
        Blog blog = iBlogRepository.findById(id);
        model.addAttribute("blog",blog);
        return "read";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id,Model model){
        Blog blog = iBlogRepository.findById(id);
        model.addAttribute("blog",blog);
        return "update";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogRepository.save(blog);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/";
    }
    @GetMapping("/remove/{id}")
    public String Remove(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        Blog blog = iBlogRepository.findById(id);
        iBlogRepository.delete(id);
        redirectAttributes.addFlashAttribute("mess","remove success");
        return "redirect:/";
    }
}
