package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;

import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/list")
    public String showListAndSearch(@RequestParam(defaultValue = "0",required = false) int page,
                           @RequestParam(defaultValue = "",required = false) String searchTitle, Model model) {
        Pageable pageable = PageRequest.of(page,5 , Sort.by("dateCreate").ascending());
        Page<Blog> blogPage = iBlogService.findAll(pageable,searchTitle);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("searchTitle",searchTitle);
        return "display";
    }
    @GetMapping("/category/{id_category}")
    public String showCategory(@RequestParam(defaultValue = "0",required = false) int page,
                                    @RequestParam(defaultValue = "",required = false) String searchTitle,
                               @PathVariable Integer id_category, Model model) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("date_create").ascending());
        Page<Blog> blogPage = iBlogService.findByCategory(pageable,id_category);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("searchTitle",searchTitle);
        return "display";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        List<Category> listCategory = iCategoryService.findAll();
        model.addAttribute("listCategory",listCategory);
        LocalDate now = LocalDate.now();
        Blog blog = new Blog();
        blog.setDateCreate(now);
        model.addAttribute("blog",blog);
        return "create";
    }
    @PostMapping("/create")
    public String Create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/list";
    }
    @GetMapping("/read/{id}")
    public String showRead(@PathVariable Integer id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "read";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id,Model model){
        List<Category> listCategory = iCategoryService.findAll();
        model.addAttribute("listCategory",listCategory);
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "update";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/list";
    }
    @GetMapping("/remove/{id}")
    public String Remove(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        Blog blog = iBlogService.findById(id);
        iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("mess","remove success");
        return "redirect:/list";
    }
}
