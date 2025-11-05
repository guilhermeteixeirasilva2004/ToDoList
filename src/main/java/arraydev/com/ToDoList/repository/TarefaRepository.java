package arraydev.com.ToDoList.repository;

import arraydev.com.ToDoList.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
