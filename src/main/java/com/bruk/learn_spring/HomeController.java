package com.bruk.learn_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("upcoming", todoRepository.findUpcoming());
        model.addAttribute("missed", todoRepository.findMissing());
        model.addAttribute("completed", todoRepository.findCompleted());
        return "home";
    }
}
