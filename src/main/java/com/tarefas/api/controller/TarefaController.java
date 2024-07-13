package com.tarefas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefas.api.model.Tarefa;
import com.tarefas.api.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    public Tarefa cadastrarTarefa(@RequestBody Tarefa tarefa){
        return tarefaService.salvarTarefa(tarefa); 
    
    }
}
