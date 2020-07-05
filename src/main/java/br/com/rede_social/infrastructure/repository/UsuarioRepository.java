package br.com.rede_social.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rede_social.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByUserName(String userName);

	@Query(nativeQuery = true, value = "SELECT * FROM T_USUARIO WHERE ID_PESSOA = :idPessoa")
	Optional<Usuario> findByIdPessoa(@Param("idPessoa") Integer idPessoa);

}
