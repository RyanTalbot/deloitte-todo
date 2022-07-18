package deloittetodo.controllers;

import deloittetodo.models.TodoElement;
import deloittetodo.repositories.TodoElementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
This controller class features everything needed for managing
our form methods.
 */

@Controller
public class TodoFormController {
    private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    @Autowired
    private TodoElementRepository todoElementRepository;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoElement todoElement) {
        return "add-todo";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TodoElement todoElement = todoElementRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoElement id: " + id + " not found"));

        model.addAttribute("todo", todoElement);
        return "update-todo";
    }

    @GetMapping("/delete/{id}")
    public String deleteToDoItem(@PathVariable("id") long id, Model model) {
        TodoElement todoElement = todoElementRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        todoElementRepository.delete(todoElement);
        return "redirect:/";
    }
}
