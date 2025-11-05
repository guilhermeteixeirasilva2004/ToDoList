package arraydev.com.ToDoList.controller;

import arraydev.com.ToDoList.model.Tarefa;
import arraydev.com.ToDoList.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa criarTarefa(@RequestBody Tarefa novaTarefa){
        return tarefaService.criarTarefa(novaTarefa);
    }

    @GetMapping
    public List<Tarefa> listarTarefas(){
        return tarefaService.listarTarefas();
    }
    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id){
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa editarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada){
        return tarefaService.atualizarTarefa(id, tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }
}
