package br.com.ebac.servico_memes.controller;

import br.com.ebac.servico_memes.entity.Meme;
import br.com.ebac.servico_memes.service.ServicoMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/memes")
public class ControllerMeme {

    @Autowired
    private ServicoMeme servicoMeme;

    @GetMapping
    public ResponseEntity<?> buscaMemes() {
        List<Meme> memes = servicoMeme.listaTodosMemes();

        if (memes.isEmpty()) {
            return ResponseEntity.ok().body("Nenhum registro encontrado.");
        } else {
            return ResponseEntity.ok(memes);
        }
    }

    @GetMapping("/aleatorio")
    public ResponseEntity<?> buscaMemeAleatorio() {
        Optional<Meme> meme = servicoMeme.buscaMemeAleatorio();

        if (meme.isEmpty()) {
            return ResponseEntity.ok().body("Nenhum registro encontrado.");
        } else {
            return ResponseEntity.ok(meme.get());
        }
    }

    @PostMapping
    public Meme novoMeme(@RequestBody Meme meme) {
        return servicoMeme.novoMeme(meme);
    }
}
