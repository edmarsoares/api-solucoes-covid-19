package br.com.rede_social.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rede_social.domain.model.Pessoa;
import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.infrastructure.repository.PessoaRepository;
import br.com.rede_social.infrastructure.repository.QuestionarioRepository;
import br.com.rede_social.presentation.dto.request.QuestionarioRequestDTO;

@Service
public class QuestionarioServiceImpl implements QuestionarioService {
	
	@Autowired
	private QuestionarioRepository questionarioRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Questionario> listAllByIdPessoa(Integer id) {
		List<Questionario> questionarios = questionarioRepository.buscarPorIdPessoa(id);
		
		return questionarios;
	}

	@Override
	public void cadastrarQuestionario(QuestionarioRequestDTO questionarioDTO) throws Exception {
		
		if (questionarioDTO != null) {
			Questionario questionario = questionarioDTO.toEntity();
			
			if (questionario.getPessoa() != null) {
				Pessoa pessoaEncontrada = pessoaRepository.findById(questionario.getPessoa().getId())
						.orElseThrow(() -> new Exception("Pessoa não encontrada"));
				
				questionario.setPessoa(pessoaEncontrada);
								
			}
			 this.questionarioRepository.save(questionario);
		}
	}
}
