package com.tarefas.api.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarefas.api.model.Tarefa;
import com.tarefas.api.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.salvarTarefa(tarefa));

    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        return ResponseEntity.ok().body(tarefaService.listarTarefa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPeloId(@PathVariable("id") Long id){
        Optional<Tarefa> tarefa = tarefaService.buscarTarefa(id);

        if (tarefa.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(tarefa.get());
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<List<Tarefa>> buscarTarefaPeloTitulo(@PathVariable("titulo") String titulo){
        return ResponseEntity.ok().body(tarefaService.buscarTarefaPeloTitulo(titulo));
    }

    @GetMapping("/data")
    public ResponseEntity<List<Tarefa>> buscarTarefaPelaData(
        @RequestParam("dataInicio") LocalDate dataInicio,
        @RequestParam("dataEntrega") LocalDate dataEntrega){
            return ResponseEntity.ok().body(tarefaService.buscarPelaDataEntrega(dataInicio, dataEntrega));
        }
        
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable("id") Long id) {
        Optional<Tarefa> tarefa = tarefaService.buscarTarefa(id);

        if (tarefa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        tarefaService.deleteTarefa(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable("id") Long id, @RequestBody Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefa = tarefaService.buscarTarefa(id);

        if (tarefa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        tarefaAtualizada.setId(id);
        return ResponseEntity.ok().body(tarefaService.salvarTarefa(tarefaAtualizada));
    }
}
