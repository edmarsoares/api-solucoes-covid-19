package br.com.rede_social.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rede_social.domain.model.Usuario;
import br.com.rede_social.presentation.dto.request.UsuarioRequestDTO;
import br.com.rede_social.presentation.dto.request.UsuarioRequestSearch;

@Service
public interface UsuarioService {

	Usuario cadastrarUsuario(UsuarioRequestDTO user);
	
	Usuario buscar(Integer idUsuario) throws Exception;

	List<Usuario> listar(UsuarioRequestSearch usuario);
	
}
