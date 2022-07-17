package deloittetodo.repositories;

import deloittetodo.models.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoEntityRepository extends CrudRepository<TodoEntity, Long> {
}
