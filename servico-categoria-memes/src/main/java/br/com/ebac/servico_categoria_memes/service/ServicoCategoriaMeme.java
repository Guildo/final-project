package br.com.ebac.servico_categoria_memes.service;

import br.com.ebac.servico_categoria_memes.client.UsuarioClient;
import br.com.ebac.servico_categoria_memes.entity.CategoriaMeme;
import br.com.ebac.servico_categoria_memes.repository.RepositorioCategoriaMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServicoCategoriaMeme {

    @Autowired
    private RepositorioCategoriaMeme repositorioCategoriaMeme;

    @Autowired
    private UsuarioClient usuarioClient;

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        ResponseEntity<?> usuario = usuarioClient.buscaUsuarioPorID(categoriaMeme.getUsuarioId());

        if (usuario.getStatusCode().isError()) {
            return null;
        } else {
            return repositorioCategoriaMeme.save(categoriaMeme);
        }
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return repositorioCategoriaMeme.findAll();
    }

    public Optional<CategoriaMeme> consultaPorId(Long id) {
        return repositorioCategoriaMeme.findById(id);
    }
}
