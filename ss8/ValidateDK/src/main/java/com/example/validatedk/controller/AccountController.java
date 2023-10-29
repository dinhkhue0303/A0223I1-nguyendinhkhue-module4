package com.example.validatedk.controller;

import com.example.validatedk.dto.AccountDto;
import com.example.validatedk.model.Account;
import com.example.validatedk.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    IAccountService iAccountService;
    @GetMapping("")
    public String ShowCreate(Model model){
        model.addAttribute("accountDto",new AccountDto());
        return "create";
    }
    @PostMapping("/create")
    public String Create(@Valid @ModelAttribute AccountDto accountDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("accountDto",accountDto);
            return "create";
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDto,account);
        iAccountService.save(account);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/";
    }
}
