package com.example.bookborrowingapplication.controller;

import com.example.bookborrowingapplication.exception.DuplicateNotExistCodeBookException;
import com.example.bookborrowingapplication.exception.DuplicateNumberEqualZeroException;
import com.example.bookborrowingapplication.model.Book;
import com.example.bookborrowingapplication.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

import static com.example.bookborrowingapplication.service.BookService.strnumber;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;
    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "0",required = false)int page,
                           @RequestParam(defaultValue = "",required = false)String searchName, Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Book> bookPage = iBookService.findAll(pageable,searchName);
        model.addAttribute("bookPage",bookPage);
        model.addAttribute("searchName",searchName);
        return "list_book";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        Book book = iBookService.findById(id);
        model.addAttribute("book",book);
        return "show_detail";
    }
    @GetMapping ("/borrow/{id}")
    public String Borrow(@PathVariable int id, RedirectAttributes redirectAttributes) throws DuplicateNumberEqualZeroException {
        Book book = iBookService.findById(id);
        iBookService.borrowBook(book);
        redirectAttributes.addFlashAttribute("mess","borrow success");
        redirectAttributes.addFlashAttribute("codeNumber"," Your book return code is " + strnumber);
        return "redirect:/list";
    }
    @GetMapping("/returnBook")
    public String ReturnBook(@RequestParam String codeBook) throws DuplicateNotExistCodeBookException {
        iBookService.returnBook(codeBook);
        return "redirect:/list";
    }
    @ExceptionHandler(DuplicateNumberEqualZeroException.class)
    public String DuplicateNumberEqualZeroException(){
        return "error_number_0";
    }
    @ExceptionHandler(DuplicateNotExistCodeBookException.class)
    public String DuplicateNotExistCodeBookException(){
        return "error_not_exist";
    }
}
