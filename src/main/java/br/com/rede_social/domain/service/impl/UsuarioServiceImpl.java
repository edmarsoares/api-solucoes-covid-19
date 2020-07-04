package br.com.rede_social.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Service;

import br.com.rede_social.domain.model.Pessoa;
import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.domain.model.Usuario;
import br.com.rede_social.domain.service.UsuarioService;
import br.com.rede_social.presentation.dto.request.UsuarioRequestDTO;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Override
	public Usuario cadastrarUsuario(UsuarioRequestDTO user) {
		
		Usuario usuario = recuperarUsuario(user);
		Pessoa pessoa = recuperarPessoa(user);
		List<Questionario> questionario = recuperarQuestionario(user);
		
		return null;

	}

	private Pessoa recuperarPessoa(UsuarioRequestDTO user) {
		Pessoa pessoa = new Pessoa();
		if (Objects.nonNull(user.getPessoaRequest())) {
			pessoa = user.getPessoaRequest().toEntity();
		}
		return pessoa;
	}

	private Usuario recuperarUsuario(UsuarioRequestDTO user) {
		if (Objects.nonNull(user)) {
			return user.toEntity();
		} else {
			return null;
		}
	}

	private List<Questionario> recuperarQuestionario(UsuarioRequestDTO user) {

		List<Questionario> lista = new ArrayList<Questionario>();
		if (user.getQuestionarioRequest() != null && user.getQuestionarioRequest().size() > 0) {
			user.getQuestionarioRequest().forEach(q -> lista.add(q.toEntity()));
		}
		return lista;
	}

}
