package br.com.rede_social.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rede_social.domain.model.Pessoa;

@Repository
public interface QuestionarioRepository extends JpaRepository<Pessoa, Integer> {
	
}
