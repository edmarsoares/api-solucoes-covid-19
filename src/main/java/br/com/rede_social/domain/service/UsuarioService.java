package br.com.rede_social.domain.service;

import org.springframework.stereotype.Service;

import br.com.rede_social.domain.model.Usuario;
import br.com.rede_social.presentation.dto.request.UsuarioRequestDTO;

@Service
public interface UsuarioService {

	Usuario cadastrarUsuario(UsuarioRequestDTO user);
	
}
