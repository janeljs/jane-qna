package com.codessquad.qna.controller;

import com.codessquad.qna.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private QuestionRepository questionRepository;

    @Autowired
    public HomeController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "index";
    }
}

