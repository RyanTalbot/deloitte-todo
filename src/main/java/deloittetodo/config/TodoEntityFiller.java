package deloittetodo.config;

import deloittetodo.models.TodoEntity;
import deloittetodo.repositories.TodoEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoEntityFiller implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(TodoEntityFiller.class);

    @Autowired
    TodoEntityRepository todoEntityRepository;

    @Override
    public void run(String... args) throws Exception {
        loadFillerData();
    }

    private void loadFillerData() {
        if (todoEntityRepository.count() == 0) {
            TodoEntity todoItem1 = new TodoEntity("Interview Ryan Talbot");
            TodoEntity todoItem2 = new TodoEntity("Checkout Ryan's GitHub");

            todoEntityRepository.save(todoItem1);
            todoEntityRepository.save(todoItem2);
        }

        logger.info("Number of Todo Entries: {}", todoEntityRepository.count());
    }
}
