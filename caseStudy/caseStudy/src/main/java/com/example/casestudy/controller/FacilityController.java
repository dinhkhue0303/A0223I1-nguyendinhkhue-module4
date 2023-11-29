package com.example.casestudy.controller;

import com.example.casestudy.dto.FacilityDto;
import com.example.casestudy.model.Facility;
import com.example.casestudy.model.FacilityType;
import com.example.casestudy.model.RentType;
import com.example.casestudy.service.IFacilityService;
import com.example.casestudy.service.IFacilityTypeService;
import com.example.casestudy.service.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService iFacilityService;
    @Autowired
    IFacilityTypeService iFacilityTypeService;
    @Autowired
    IRentTypeService iRentTypeService;
    @GetMapping("/list")
    public String List(@RequestParam (defaultValue = "0", required = false)int page,
                       @RequestParam (defaultValue = "", required = false)String searchName, Model model){
        Pageable pageable = PageRequest.of(page,5, Sort.by("id").ascending());
        Page<Facility> facilityPage = iFacilityService.findAll(pageable,searchName);
        model.addAttribute("facilityPage",facilityPage);
        model.addAttribute("searchName",searchName);
        List<FacilityType> facilityTypeList = iFacilityTypeService.findAll();
        model.addAttribute("facilityTypeList",facilityTypeList);
        return "facility/facility";
    }
    @GetMapping("/create/{facilityTypeId}")
    public String showCreate(@PathVariable Long facilityTypeId, Model model){
        List<RentType> rentTypeList = iRentTypeService.findAll();
        model.addAttribute("rentTypeList",rentTypeList);
        FacilityDto facilityDto = new FacilityDto();
        model.addAttribute("facilityDto",facilityDto);
        FacilityType facilityType = iFacilityTypeService.findById(facilityTypeId);
        facilityDto.setFacilityType(facilityType);
        model.addAttribute("facilityType",facilityType);
        if(facilityTypeId == 1){
            return "facility/room/showCreateRoomFacility";
        }else if(facilityTypeId == 2){
            return "facility/villa/showCreateVillaFaciliry";
        }
        return "facility/house/showCreateHouseFacility";
    }
    @PostMapping("/create")
    public String Create(@Valid @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("facilityDto",facilityDto);
            List<RentType> rentTypeList = iRentTypeService.findAll();
            model.addAttribute("rentTypeList",rentTypeList);
            if(facilityDto.getFacilityType().getId() == 1){
                return "facility/room/showCreateRoomFacility";
            }else if(facilityDto.getFacilityType().getId() == 2){
                return "facility/villa/showCreateVillaFaciliry";
            }
            return "facility/house/showCreateHouseFacility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/facility/list";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Long id,Model model){
        List<RentType> rentTypeList = iRentTypeService.findAll();
        model.addAttribute("rentTypeList",rentTypeList);
        Facility facility = iFacilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facilityDto",facilityDto);
        if(facilityDto.getFacilityType().getId() == 1){
            return "facility/room/showUpdateRoomFacility";
        }else if(facilityDto.getFacilityType().getId() == 2){
            return "facility/villa/showUpdateVillaFacility";
        }
        return "facility/house/showUpdateHouseFacility";
    }
    @PostMapping("/update")
    public String Update(@Valid @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("facilityDto",facilityDto);
            List<RentType> rentTypeList = iRentTypeService.findAll();
            model.addAttribute("rentTypeList",rentTypeList);
            if(facilityDto.getFacilityType().getId() == 1){
                return "facility/room/showCreateRoomFacility";
            }else if(facilityDto.getFacilityType().getId() == 2){
                return "facility/villa/showCreateVillaFaciliry";
            }
            return "facility/house/showCreateHouseFacility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/facility/list";
    }
    @GetMapping("/remove/{id}")
    public String Remove(@PathVariable Long id, RedirectAttributes redirectAttributes){
        iFacilityService.remove(id);
        redirectAttributes.addFlashAttribute("mess","remove success");
        return "redirect:/facility/list";
    }
}
