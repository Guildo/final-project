package br.com.ebac.servico_categoria_memes.controller;

import br.com.ebac.servico_categoria_memes.entity.CategoriaMeme;
import br.com.ebac.servico_categoria_memes.service.ServicoCategoriaMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class ControllerCategoriaMeme {

    @Autowired
    private ServicoCategoriaMeme servicoCategoriaMeme;

    @GetMapping
    public ResponseEntity<?> buscaCategorias() {
        List<CategoriaMeme> categoriasMeme = servicoCategoriaMeme.listaTodasCategorias();

        if (categoriasMeme.isEmpty()) {
            return ResponseEntity.ok().body("Nenhum registro encontrado.");
        } else {
            return ResponseEntity.ok(categoriasMeme);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaCategoriaPorId(@PathVariable Long id) {
        Optional<CategoriaMeme> categoriaMeme = servicoCategoriaMeme.consultaPorId(id);

        if (categoriaMeme.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria de Meme com ID " + id + " não encontrada.");
        } else {
            return ResponseEntity.ok(categoriaMeme.get());
        }
    }

    @PostMapping
    public CategoriaMeme novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        return servicoCategoriaMeme.novaCategoriaMeme(categoriaMeme);
    }
}
