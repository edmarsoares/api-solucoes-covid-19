package br.com.rede_social.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.rede_social.domain.model.Pessoa;
import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.domain.model.Usuario;
import br.com.rede_social.domain.service.UsuarioService;
import br.com.rede_social.infrastructure.exception.UsuarioExistenteException;
import br.com.rede_social.infrastructure.exception.UsuarioNaoEncontradoException;
import br.com.rede_social.infrastructure.repository.PessoaRepository;
import br.com.rede_social.infrastructure.repository.QuestionarioRepository;
import br.com.rede_social.infrastructure.repository.UsuarioRepository;
import br.com.rede_social.presentation.dto.request.UsuarioRequestDTO;
import br.com.rede_social.presentation.dto.request.UsuarioRequestSearch;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private QuestionarioRepository questionarioRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Usuario cadastrarUsuario(UsuarioRequestDTO user) {
		Usuario usuario = convertUserToEntity(user);
		List<Questionario> questionario = convertQuestionarioToEntity(user);
		Usuario userSalvo = salvarUsuario(usuario);
		salvarQuestionario(questionario, userSalvo);
		return userSalvo;
	}

	private Usuario salvarUsuario(Usuario usuario) {
		validaUsuarioExistente(usuario);
		Usuario userSalvo = usuarioRepository.save(usuario);
		return userSalvo;
	}

	private void salvarQuestionario(List<Questionario> questionario, Usuario userSalvo) {
		List<Questionario> listQuestionario = Lists.newArrayList();
		questionario.forEach(q -> {
			q.setPessoa(userSalvo.getPessoa());
			Questionario salvo = questionarioRepository.save(q);
			listQuestionario.add(salvo);
		});
		userSalvo.getPessoa().setQuestionario(listQuestionario);
	}

	private void validaUsuarioExistente(Usuario usuario) {
		Optional<Usuario> user = Optional.ofNullable(null);
		user = usuarioRepository.findByEmail(usuario.getEmail());
		if(user.isPresent()) {
			throw new UsuarioExistenteException();
		}
		user = usuarioRepository.findByUserName(usuario.getUserName());
		if(user.isPresent()) {
			throw new UsuarioExistenteException();
		}
	}

	private Usuario convertUserToEntity(UsuarioRequestDTO user) {
		if (Objects.nonNull(user)) {
			return user.toEntity();
		} else {
			return null;
		}
	}

	private List<Questionario> convertQuestionarioToEntity(UsuarioRequestDTO user) {

		List<Questionario> lista = new ArrayList<Questionario>();
		if (user.getQuestionarioRequest() != null && user.getQuestionarioRequest().size() > 0) {
			user.getQuestionarioRequest().forEach(q -> lista.add(q.toEntity()));
		}
		return lista;
	}

	@Override
	public Usuario buscar(Integer idUsuario) throws Exception {
		return usuarioRepository.findById(idUsuario).orElseThrow(() -> new Exception("Usuario não encontrado"));
	}

	@Override
	public List<Usuario> listar(UsuarioRequestSearch usuario) {

		Usuario usuarioBuscado = null;
		
		List<Usuario> usuarioList = Lists.newArrayList();

		if (Objects.nonNull(usuario.getEmail()) && !usuario.getEmail().isBlank()) {
			usuarioBuscado = usuarioRepository.findByEmail(usuario.getEmail())
					.orElseThrow(() -> new UsuarioNaoEncontradoException());
			usuarioList.add(usuarioBuscado);
			return usuarioList;
		}
		if (Objects.nonNull(usuario.getUsuario()) && !usuario.getUsuario().isBlank()) {
			usuarioBuscado = usuarioRepository.findByUserName(usuario.getUsuario())
					.orElseThrow(() -> new UsuarioNaoEncontradoException());
			usuarioList.add(usuarioBuscado);
			return usuarioList;
		}
		if (Objects.nonNull(usuario.getTelefone()) && !usuario.getTelefone().isBlank()) {
			Pessoa pessoa = pessoaRepository.findByCelular(usuario.getTelefone())
					.orElseThrow(() -> new UsuarioNaoEncontradoException());
			usuarioBuscado = usuarioRepository.findByIdPessoa(pessoa.getId()).get();
			usuarioList.add(usuarioBuscado);
			return usuarioList;
		}

		if (Objects.isNull(usuarioBuscado) && usuarioList.size() == 0) {
			usuarioList = usuarioRepository.findAll();
		}

		return usuarioList;
	}

}
