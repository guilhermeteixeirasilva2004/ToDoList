package arraydev.com.ToDoList.service;

import arraydev.com.ToDoList.model.Usuario;
import arraydev.com.ToDoList.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario novoUsuario){
        return usuarioRepository.save(novoUsuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com ID: " + id));
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioDetalhe){
        Usuario usuarioExistente = buscarPorId(id);

        usuarioExistente.setNomeUsuario(usuarioDetalhe.getNomeUsuario());
        usuarioExistente.setEmail(usuarioDetalhe.getEmail());
        usuarioExistente.setSenha(usuarioDetalhe.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }
    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
