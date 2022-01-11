package com.bruk.learn_spring;

import lombok.Data;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoForm {
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 20, message = "Title must be between 3 and 20 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 100, message = "Description must be between 3 and 100 characters")
    private String description;

    @Future(message = "Deadline must be in the future")
    @NotNull(message = "Deadline is required")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date deadline;

    public Todo getTodo() {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setDeadline(deadline);
        todo.setCompleted(false);
        return todo;
    }
}
