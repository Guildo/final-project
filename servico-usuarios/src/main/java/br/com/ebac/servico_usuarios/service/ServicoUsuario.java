package br.com.ebac.servico_usuarios.service;

import br.com.ebac.servico_usuarios.entity.Usuario;
import br.com.ebac.servico_usuarios.repository.RepositorioUsuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServicoUsuario {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    public Usuario novoUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Optional<Usuario> consultaPorId(Long id) {
        return repositorioUsuario.findById(id);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }
}
