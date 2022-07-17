package deloittetodo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoElementController {
    private final Logger logger = LoggerFactory.getLogger(TodoElementController.class);

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
