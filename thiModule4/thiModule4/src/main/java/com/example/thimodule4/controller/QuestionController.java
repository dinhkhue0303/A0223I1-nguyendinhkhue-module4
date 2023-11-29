package com.example.thimodule4.controller;

import com.example.thimodule4.dto.QuestionDto;
import com.example.thimodule4.model.Question;
import com.example.thimodule4.model.QuestionType;
import com.example.thimodule4.repository.IQuestionTypeRepository;
import com.example.thimodule4.service.IQuestionService;
import com.example.thimodule4.service.IQuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;
    @Autowired
    IQuestionTypeService iQuestionTypeService;
    @GetMapping("/list")
    public String showList(@RequestParam (defaultValue = "0", required = false)int page,
                           @RequestParam (defaultValue = "", required = false)String searchTitle, Model model){
        Pageable pageable = PageRequest.of(page,3, Sort.by("status").ascending());
        Page<Question> questionPage = iQuestionService.findAll(pageable,searchTitle);
        model.addAttribute("questionPage",questionPage);
        model.addAttribute("title",searchTitle);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        List<QuestionType> questionTypeList = iQuestionTypeService.findAll();
        model.addAttribute("questionTypeList",questionTypeList);
        LocalDate now = LocalDate.now();
        QuestionDto questionDto = new QuestionDto();
        questionDto.setDateCreate(now);
        questionDto.setStatus(false);
        questionDto.setAnswer("N/A");
        model.addAttribute("questionDto",questionDto);
        return "showCreate";
    }
    @PostMapping("/create")
    public String Create(@Valid @ModelAttribute QuestionDto questionDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        new QuestionDto().validate(questionDto,bindingResult);
        if(bindingResult.hasErrors()){
            List<QuestionType> questionTypeList = iQuestionTypeService.findAll();
            model.addAttribute("questionTypeList",questionTypeList);
            model.addAttribute("questionDto",questionDto);
            return "showCreate";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        iQuestionService.save(question);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/question/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id,Model model){
        Question question = iQuestionService.findById(id);
        model.addAttribute("question",question);
        return "showDetail";
    }
    @GetMapping("/delete")
    public String Delete(@RequestParam Long delete_id, RedirectAttributes redirectAttributes){
        iQuestionService.delete(delete_id);
        redirectAttributes.addFlashAttribute("mess","delete success");
        return "redirect:/question/list";
    }
}
