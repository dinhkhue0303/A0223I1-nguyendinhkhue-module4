package com.example.validatebh.controller;

import com.example.validatebh.dto.SongDto;
import com.example.validatebh.model.Song;
import com.example.validatebh.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;
    @GetMapping("")
    public String showList(Model model){
        List<Song> list = iSongService.display();
        model.addAttribute("list",list);
        return "display";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("songDto", new SongDto());
        return "create";
    }
    @PostMapping("/create")
    public String Create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model){
        Song song = iSongService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "update";
    }
    @PostMapping ("/update")
    public String Update(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/";
    }
}
