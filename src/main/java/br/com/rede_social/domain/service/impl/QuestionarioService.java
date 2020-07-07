package br.com.rede_social.domain.service.impl;

import java.util.List;

import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.presentation.dto.request.QuestionarioRequestDTO;

public interface QuestionarioService {
	
	List<Questionario> listAllByIdPessoa(Integer id); 
	void cadastrarQuestionario(QuestionarioRequestDTO questionarioDTO) throws Exception;
}
