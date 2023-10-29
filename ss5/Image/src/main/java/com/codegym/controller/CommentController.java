package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    ICommentRepository iCommentRepository;
    @GetMapping("")
    public String showList(Model model){
        List<Comment> list = iCommentRepository.display();
        model.addAttribute("list",list);
        model.addAttribute("comment",new Comment());
        model.addAttribute("listPoint",new Integer[]{1,2,3,4,5});
        return "display";
    }
    @PostMapping("/create")
    public String Create(@ModelAttribute Comment comment){
        iCommentRepository.save(comment);
        return "redirect:/";
    }
    @GetMapping("/like/{id}")
    public String save(@PathVariable Integer id){
        iCommentRepository.save(iCommentRepository.findById(id));
        return "redirect:/";
    }
}
