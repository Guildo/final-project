package br.com.ebac.servico_memes.service;

import br.com.ebac.servico_memes.client.CategoriaMemeClient;
import br.com.ebac.servico_memes.client.UsuarioClient;
import br.com.ebac.servico_memes.entity.Meme;
import br.com.ebac.servico_memes.repository.RepositorioMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServicoMeme {

    @Autowired
    private RepositorioMeme repositorioMeme;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CategoriaMemeClient categoriaMemeClient;

    public Meme novoMeme(Meme meme) {
        ResponseEntity<?> usuario = usuarioClient.buscaUsuarioPorID(meme.getUsuarioId());
        ResponseEntity<?> categoriaMeme = categoriaMemeClient.buscaCategoriaPorId(meme.getCategoriaMemeId());

        if (usuario == null || categoriaMeme == null) {
            return null;
        } else {
            return repositorioMeme.save(meme);
        }
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

    public Optional<Meme> buscaMemeAleatorio() {
        return repositorioMeme.findRandomMeme();
    }
 }
