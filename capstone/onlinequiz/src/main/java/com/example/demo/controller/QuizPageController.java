package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizPageController {

    @GetMapping("/mcq")
    public String showMcq() {
        return "mcq-quiz";
    }
}