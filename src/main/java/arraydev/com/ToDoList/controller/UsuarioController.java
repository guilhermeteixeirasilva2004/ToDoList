package arraydev.com.ToDoList.controller;

import arraydev.com.ToDoList.model.Tarefa;
import arraydev.com.ToDoList.model.Usuario;
import arraydev.com.ToDoList.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody Usuario novoUsuario){
        return usuarioService.criarUsuario(novoUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
}
