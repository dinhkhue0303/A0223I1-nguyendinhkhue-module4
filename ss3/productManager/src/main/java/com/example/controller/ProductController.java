package com.example.controller;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    IProductRepository iProductRepository;
    @GetMapping("")
    public ModelAndView showList(){
        List<Product> Productlist = iProductRepository.display();
        ModelAndView modelAndView = new ModelAndView("list","Productlist",Productlist);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("ListMoTa",new String[]{"con hang","het hang"});
        model.addAttribute("ListNhaSX",new String[]{"VN","MY","NC"});
        return "create";
    }
    @PostMapping("create")
    public String Create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        iProductRepository.create(product);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model){
        Product product = iProductRepository.findById(id);
        model.addAttribute("product",product);
        model.addAttribute("ListMoTa",new String[]{"con hang","het hang"});
        model.addAttribute("ListNhaSX",new String[]{"VN","MY","NC"});
        return "update";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute Product product){
        iProductRepository.update(product);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable int id){
        iProductRepository.remove(id);
        return "redirect:/";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        Product product = iProductRepository.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }
    @GetMapping("/findName")
    public String showFindName(@RequestParam String name, Model model){
        List<Product> list = iProductRepository.findName(name);
        model.addAttribute("list",list);
        return "find";
    }
}
