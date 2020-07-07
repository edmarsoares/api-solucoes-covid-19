package br.com.rede_social.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rede_social.domain.model.Pessoa;
import br.com.rede_social.domain.model.Questionario;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Integer> {
	
	@Query("SELECT Q FROM Questionario Q WHERE Q.pessoa.id = :idPessoa ")
	List<Questionario> buscarPorIdPessoa(@Param("idPessoa") Integer id);
}
