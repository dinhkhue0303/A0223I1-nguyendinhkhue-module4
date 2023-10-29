package com.example.image.controller;


import com.example.image.exception.DuplicateBadWordFeedback;
import com.example.image.model.Comment;
import com.example.image.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    ICommentService iCommentService;
    @GetMapping("")
    public String show(@RequestParam(defaultValue = "0",required = false) int page, Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Comment> Commentpage = iCommentService.findAll(pageable);
        model.addAttribute("Commentpage",Commentpage);
        model.addAttribute("listPoint",new Integer[]{1,2,3,4,5});
        model.addAttribute("comment",new Comment());
        return "display";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Comment comment) throws DuplicateBadWordFeedback{
        iCommentService.save(comment);
        return "redirect:/";
    }
    @GetMapping("/like/{id}")
    public String save(@PathVariable Integer id) throws DuplicateBadWordFeedback{
        Comment comment = iCommentService.findById(id);
        comment.setNumberOfLike(comment.getNumberOfLike()+1);
        iCommentService.save(comment);
        return "redirect:/";
    }
    @ExceptionHandler(DuplicateBadWordFeedback.class)
    public String handleAmin(){
        return "error_bad_word";
    }
}
