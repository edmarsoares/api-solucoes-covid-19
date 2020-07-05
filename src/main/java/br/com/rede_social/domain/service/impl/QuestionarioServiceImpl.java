package br.com.rede_social.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.infrastructure.repository.QuestionarioRepository;

@Service
public class QuestionarioServiceImpl implements QuestionarioService {
	
	@Autowired
	private QuestionarioRepository questionarioRepository;
	
	@Override
	public List<Questionario> listAllByIdPessoa(Integer id) {
		return questionarioRepository.findByPessoaId(id);
	}
}
