package br.com.rede_social.domain.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rede_social.domain.model.Pessoa;
import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.domain.model.Sexo;
import br.com.rede_social.domain.model.Usuario;
import br.com.rede_social.domain.service.PessoaService;
import br.com.rede_social.domain.service.UsuarioService;
import br.com.rede_social.infrastructure.repository.QuestionarioRepository;
import br.com.rede_social.infrastructure.repository.UsuarioRepository;
import br.com.rede_social.presentation.dto.request.PessoaRequestDTO;
import br.com.rede_social.presentation.dto.request.UsuarioRequestDTO;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private QuestionarioRepository questionarioRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario cadastrarUsuario(UsuarioRequestDTO user) {
		Usuario usuario = recuperarUsuario(user);
		List<Questionario> questionario = recuperarQuestionario(user);
		//Pessoa pessoaSalva = pessoaService.save(usuario.getPessoa());
		Usuario userSalvo = usuarioRepository.save(usuario);
		questionario.forEach(q-> {
			 q.setPessoa(userSalvo.getPessoa());
			 questionarioRepository.save(q);
		});
		return userSalvo;
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
	
	public static void main(String[] args) {
		PessoaRequestDTO pessoa = new PessoaRequestDTO();
		pessoa.setCelular("83988451169");
		pessoa.setNomeCompleto("david de almeida ");
		pessoa.setSexo(Sexo.MASCULINO);
		pessoa.setDataNascimento(LocalDate.of(1995,06,6));
		UsuarioRequestDTO dto = new UsuarioRequestDTO();
		dto.setEmail("david_almeida@hotmial.com");
		dto.setUserName("davidalmeida14");
		dto.setPassword("1234");
		dto.setPessoaRequest(pessoa);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
