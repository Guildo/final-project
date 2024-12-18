package br.com.ebac.servico_categoria_memes.repository;

import br.com.ebac.servico_categoria_memes.entity.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCategoriaMeme extends JpaRepository<CategoriaMeme, Long> {
}
