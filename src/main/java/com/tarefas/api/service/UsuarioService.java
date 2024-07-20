package com.tarefas.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefas.api.model.Usuario;
import com.tarefas.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario>listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> buscarUsuarioPeloEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> buscarUsuarioPeloNome(String nome){
        return usuarioRepository.findByNomeLike(nome);
    }

    public List<Usuario> buscarUsuarioPelaDataNascimento(LocalDate dataInicio, LocalDate dataFim){
        return usuarioRepository.findByDataNascimentoBetween(dataInicio, dataFim);
    }

}
