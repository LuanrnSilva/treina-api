package com.tarefas.api.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarefas.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    //Like busca todos os usuarios que tem aquele conjunto de caracteres que foi inserido
    // ex : Lu -- Luan, Luan, Lucas ....

    List<Usuario> findByNomeLike(String nome);

    Optional<Usuario> findByEmail(String email);

    //betwenn busca tudo em um intervalo de inicio e fim de algum atributo.
    List<Usuario> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);

} 
