package arraydev.com.ToDoList.service;

import arraydev.com.ToDoList.model.Tarefa;
import arraydev.com.ToDoList.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa novaTarefa){
        return tarefaRepository.save(novaTarefa);
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id){
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaDetalhes){
        Tarefa tarefaExistente = buscarPorId(id);

        tarefaExistente.setNomeDaTarefa(tarefaDetalhes.getNomeDaTarefa());
        tarefaExistente.setDescricaoDaTarefa(tarefaDetalhes.getDescricaoDaTarefa());
        tarefaExistente.setTipoDaTarefa(tarefaDetalhes.getTipoDaTarefa());

        return tarefaRepository.save(tarefaExistente);
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }
}
