package com.bruk.learn_spring;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;

    @GetMapping("/todo")
    public String todoForm(Model model) {
        model.addAttribute("todo", new TodoForm());
        return "todo";
    }

    @PostMapping("/todo")
    public String addTodo(@Valid @ModelAttribute("todo") TodoForm todo, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Validation errors: {}", errors);
            return "todo";
        }

        log.info("Todo added: {}", todo);
        todoRepository.save(todo.getTodo());
        return "redirect:/";
    }

    @PostMapping("/modify-todo")
    public String modifyTodo(long id, boolean isCompleted) {
        log.info("Todo modified: id {}", id);
        todoRepository.findById(id).ifPresent(todo -> {
            todo.setCompleted(isCompleted);
            todoRepository.save(todo);
        });
        return "redirect:/";
    }

    @PostMapping("/delete-todo")
    public String deleteTodo(long id) {
        log.info("Todo deleted: id {}", id);
        todoRepository.deleteById(id);
        return "redirect:/";
    }

}
