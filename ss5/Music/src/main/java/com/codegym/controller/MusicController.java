package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    IMusicRepository iMusicRepository;
    @GetMapping("")
    public ModelAndView showList(){
        List<Music> ListMusic = iMusicRepository.display();
        ModelAndView modelAndView = new ModelAndView("display","ListMusic",ListMusic);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }
    @PostMapping("/create")
    public String Create(@ModelAttribute Music music, RedirectAttributes redirectAttributes){
        iMusicRepository.save(music);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model){
        Music music = iMusicRepository.findId(id);
        model.addAttribute("music",music);
        return "update";
    }
    @PostMapping("/update")
    public String Update(@ModelAttribute Music music,RedirectAttributes redirectAttributes){
        iMusicRepository.save(music);
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable Integer id){
        iMusicRepository.delete(id);
        return "redirect:/";
    }
    @GetMapping("/listen/{id}")
    public String Listen(@PathVariable Integer id,Model model){
        Music music = iMusicRepository.findId(id);
        model.addAttribute("music",music);
        return "listen";
    }
    @Value("${file-upload}")
    private String fileUpload;
}
