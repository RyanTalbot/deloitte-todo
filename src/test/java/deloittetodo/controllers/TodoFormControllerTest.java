package deloittetodo.controllers;

import deloittetodo.models.TodoElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoFormControllerTest {

    @Test
    void showCreateForm() {
        TodoFormController controller = new TodoFormController();
        TodoElement todoElement = new TodoElement();

        String response = controller.showCreateForm(todoElement);
        assertEquals("add-todo", response);
    }

}