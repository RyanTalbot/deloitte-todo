package deloittetodo.repositories;

import deloittetodo.models.TodoElement;
import org.springframework.data.repository.CrudRepository;

public interface TodoElementRepository extends CrudRepository<TodoElement, Long> {
}
