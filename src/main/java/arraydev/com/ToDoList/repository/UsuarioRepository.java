package arraydev.com.ToDoList.repository;

import arraydev.com.ToDoList.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
