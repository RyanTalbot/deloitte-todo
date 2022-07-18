package deloittetodo.config;

import deloittetodo.models.TodoElement;
import deloittetodo.repositories.TodoElementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
This class features some filler data which populates
new logins task lists with sample data.
 */

@Component
public class TodoElementFiller implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(TodoElementFiller.class);

    @Autowired
    TodoElementRepository todoElementRepository;

    @Override
    public void run(String... args) throws Exception {
        loadFillerData();
    }

    private void loadFillerData() {
        if (todoElementRepository.count() == 0) {
            TodoElement todoItem1 = new TodoElement("Interview Ryan Talbot");
            TodoElement todoItem2 = new TodoElement("Checkout Ryan's GitHub");

            todoElementRepository.save(todoItem1);
            todoElementRepository.save(todoItem2);
        }

        logger.info("Number of Todo Elements: {}", todoElementRepository.count());
    }
}
