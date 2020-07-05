package br.com.rede_social.presentation.dto.request;

import lombok.Data;

@Data
public class UsuarioRequestSearch {
	private String telefone;
	private String usuario;
	private String email;
}
