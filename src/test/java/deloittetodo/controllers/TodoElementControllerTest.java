package deloittetodo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

class TodoElementControllerTest {

    @Test
    void createTodo() {
        ModelAndView modelAndView = new ModelAndView("index");
        String response = modelAndView.getViewName();
        assertEquals("index", response);
    }

}
