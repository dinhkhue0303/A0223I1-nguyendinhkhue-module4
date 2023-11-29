package com.example.casestudy.controller;

import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.CustomerType;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;
    @GetMapping("/list")
    public String List(@RequestParam(defaultValue = "0", required = false)int page,
                       @RequestParam(defaultValue = "",required = false) String searchName, Model model){
        Pageable pageable = PageRequest.of(page,5, Sort.by("id").ascending());
        Page<Customer> customerPage = iCustomerService.findAll(pageable,searchName);
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("searchName",searchName);
        return "customer/customer";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList",customerTypeList);
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto",customerDto);
        return "customer/showCreateCustomer";
    }
    @PostMapping("/create")
    public String Create(@Valid @ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes,
                         BindingResult bindingResult, Model model){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("customerDto",customerDto);
            List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
            model.addAttribute("customerTypeList",customerTypeList);
            return "customer/showCreateCustomer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/customer/list";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model){
        Customer customer = iCustomerService.findById(id);
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        model.addAttribute("customerTypeList",customerTypeList);
        return "customer/showUpdateCustomer";
    }
    @PostMapping("/update")
    public String Update(@Valid @ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes,
                         BindingResult bindingResult, Model model){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("customerDto",customerDto);
            List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
            model.addAttribute("customerTypeList",customerTypeList);
            return "customer/showUpdateCustomer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/customer/list";
    }
    @GetMapping("/remove")
    public String Remove(@RequestParam Long delete_id, RedirectAttributes redirectAttributes){
        iCustomerService.remove(delete_id);
        redirectAttributes.addFlashAttribute("mess","remove success");
        return "redirect:/customer/list";
    }
}
