package br.com.ebac.servico_usuarios.repository;

import br.com.ebac.servico_usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
