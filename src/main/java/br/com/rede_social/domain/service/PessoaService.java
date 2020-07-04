package br.com.rede_social.domain.service;

import java.util.List;
import java.util.Optional;

import br.com.rede_social.domain.model.Pessoa;

public interface PessoaService {
	
	void save(Pessoa pessoa);
	void remove(Integer id);
	Optional<Pessoa> findById(Integer id);
	List<Pessoa> listAll();
}
