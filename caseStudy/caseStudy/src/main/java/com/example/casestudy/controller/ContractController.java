package com.example.casestudy.controller;

import com.example.casestudy.dto.ContractDetailDto;
import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.*;
import com.example.casestudy.service.*;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;
    @Autowired
    IFacilityService iFacilityService;
    @Autowired
    ICustomerService icustomerService;
    @Autowired
    IAttachFacilityService iAttachFacilityService;
    @Autowired
    IContractDetailService iContractDetailService;
    @GetMapping("/list")
    public String List(@RequestParam (defaultValue = "0", required = false)int page,
                       @RequestParam (defaultValue = "", required = false)String searchName, Model model){
        Pageable pageable = PageRequest.of(page,5, Sort.by("id").ascending());
        Page<Contract> contractPage = iContractService.findContractByFacility(pageable,searchName);
        model.addAttribute("contractPage",contractPage);
        model.addAttribute("searchName",searchName);
        return "contract/contract";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        List<Customer> customerList = icustomerService.findAll();
        List<Facility> facilityList = iFacilityService.findAll();
        model.addAttribute("customerList",customerList);
        model.addAttribute("facilityList",facilityList);
        ContractDto contractDto = new ContractDto();
        model.addAttribute("contractDto",contractDto);
        return "contract/showCreateContract";
    }
    @PostMapping("/create")
    public String Create(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("contractDto",contractDto);
            List<Customer> customerList = icustomerService.findAll();
            List<Facility> facilityList = iFacilityService.findAll();
            model.addAttribute("customerList",customerList);
            model.addAttribute("facilityList",facilityList);
            return "contract/showCreateContract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/contract/list";
    }
    @GetMapping("/attachServiceList/{ContractId}")
    public String showAttachServiceList(@PathVariable Long ContractId,Model model){
        List<AttachFacility> attachFacilityList = iAttachFacilityService.findAll(ContractId);
        model.addAttribute("attachFacilityList",attachFacilityList);
        return "contract/AttachServiceList";
    }
    @GetMapping("/addAttachService/{ContractId}")
    public String showAddAttachService(@PathVariable Long ContractId,Model model){
        List<AttachFacility> NotattachFacilityList = iAttachFacilityService.findAllNotIn(ContractId);
        model.addAttribute("NotAttachFacilityList",NotattachFacilityList);
        model.addAttribute("ContractId",ContractId);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        model.addAttribute("contractDetailDto",contractDetailDto);
        return "contract/AddAttachService";
    }
    @PostMapping("/addAttachService")
    public String AddAttachService(@Valid @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model){
        if(contractDetailDto.getAttachFacility() == null){
            model.addAttribute("ContractId",contractDetailDto.getContract().getId());
            return "error_isEmty";
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("contractDetailDto",contractDetailDto);
            List<AttachFacility> NotattachFacilityList = iAttachFacilityService.findAllNotIn(contractDetailDto.getContract().getId());
            model.addAttribute("NotAttachFacilityList",NotattachFacilityList);
            model.addAttribute("ContractId",contractDetailDto.getContract().getId());
            return "contract/AddAttachService";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        iContractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }
}
