package com.bruk.learn_spring;

import com.bruk.learn_spring.security.User;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("upcoming", todoRepository.findUpcoming(user));
        model.addAttribute("missed", todoRepository.findMissing(user));
        model.addAttribute("completed", todoRepository.findCompleted(user));
        return "home";
    }
}
