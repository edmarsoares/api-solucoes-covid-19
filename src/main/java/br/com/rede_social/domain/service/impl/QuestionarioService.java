package br.com.rede_social.domain.service.impl;

import java.util.List;

import br.com.rede_social.domain.model.Questionario;

public interface QuestionarioService {
	
	List<Questionario> listAllByIdPessoa(Integer id); 
}
