package deloittetodo.controllers;

import deloittetodo.models.TodoElement;
import deloittetodo.repositories.TodoElementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;

@Controller
public class TodoElementController {
    private final Logger logger = LoggerFactory.getLogger(TodoElementController.class);

    @Autowired
    private TodoElementRepository todoElementRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoElements", todoElementRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodo(@Valid TodoElement todoElement, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todo";
        }

        todoElement.setLastModified(Instant.now());
        todoElementRepository.save(todoElement);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodo(@PathVariable("id") long id, @Valid TodoElement todoElement, BindingResult result, Model model) {
        if (result.hasErrors()) {
            todoElement.setId(id);
            return "update-todo";
        }

        todoElement.setLastModified(Instant.now());
        todoElementRepository.save(todoElement);
        return "redirect:/";
    }
}
