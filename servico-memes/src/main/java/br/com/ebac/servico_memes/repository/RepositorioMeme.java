package br.com.ebac.servico_memes.repository;

import br.com.ebac.servico_memes.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepositorioMeme extends JpaRepository<Meme, Long> {

    @Query("SELECT a FROM Meme a ORDER BY RAND() LIMIT 1")
    Optional<Meme> findRandomMeme();
}
