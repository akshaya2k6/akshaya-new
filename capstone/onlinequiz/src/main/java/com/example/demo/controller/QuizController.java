package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.Quiz;
import com.example.demo.service.QuizService;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quizzes")
    public String viewQuizzes(Model model) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        model.addAttribute("quizzes", quizzes);
        return "quizzes";  // Thymeleaf template name
    }

    @GetMapping("/addQuiz")
    public String addQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "addQuiz"; // Thymeleaf template
    }

    @PostMapping("/saveQuiz")
    public String saveQuiz(@ModelAttribute Quiz quiz) {
        quizService.saveQuiz(quiz);
        return "redirect:/quizzes";
    }
}
