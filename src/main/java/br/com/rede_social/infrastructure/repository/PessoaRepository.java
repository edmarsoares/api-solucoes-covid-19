package br.com.rede_social.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rede_social.domain.model.Questionario;

@Repository
public interface PessoaRepository extends JpaRepository<Questionario, Integer> {
	
}
