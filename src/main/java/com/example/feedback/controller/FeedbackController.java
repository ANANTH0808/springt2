package com.example.feedback.controller;

import com.example.feedbackapp.model.Feedback;
import com.example.feedbackapp.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback_form";
    }

    @PostMapping("/submit")
    public String submitFeedback(@ModelAttribute Feedback feedback, Model model) {
        feedbackRepository.save(feedback);
        model.addAttribute("message", "Feedback saved");
        return "feedback_result";
    }
}
