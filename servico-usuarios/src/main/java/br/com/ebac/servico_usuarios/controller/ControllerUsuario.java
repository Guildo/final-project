package br.com.ebac.servico_usuarios.controller;

import br.com.ebac.servico_usuarios.entity.Usuario;
import br.com.ebac.servico_usuarios.service.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    private ServicoUsuario servicoUsuario;

    @GetMapping
    public ResponseEntity<?> buscaUsuarios() {
        List<Usuario> usuarios = servicoUsuario.listaTodosUsuarios();

        if (usuarios.isEmpty()) {
            return ResponseEntity.ok().body("Nenhum registro encontrado");
        } else {
            return ResponseEntity.ok(usuarios);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = servicoUsuario.consultaPorId(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID " + id + " não encontrado.");
        } else {
            return ResponseEntity.ok(usuario.get());
        }
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return servicoUsuario.novoUsuario(usuario);
    }
}
