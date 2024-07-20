package com.tarefas.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarefas.api.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByTituloLike(String titulo);

    List<Tarefa> findByResponsavel_Id(Long id);

    List<Tarefa> findByDataEntregaBetween(LocalDate dataIncio, LocalDate dataEntrega);
}
