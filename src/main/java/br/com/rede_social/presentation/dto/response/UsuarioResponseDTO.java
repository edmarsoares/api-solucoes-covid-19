package br.com.rede_social.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
	
	@JsonProperty(value = "idUsuario")
	private Integer id;
	private Integer idPessoa;
	private String userName;
	private String email;
	
}
