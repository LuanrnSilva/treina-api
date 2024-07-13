package com.tarefas.api.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefas.api.model.Tarefa;
import com.tarefas.api.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefa(){
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarTarefa(Long id){
        return tarefaRepository.findById(id);
    }

    public void deleteTarefa(Long id){
        tarefaRepository.deleteById(id);
    }
}
