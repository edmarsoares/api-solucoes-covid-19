package br.com.rede_social.presentation.dto.request;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.rede_social.domain.model.Usuario;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class UsuarioRequestDTO {
	
	@JsonProperty(value = "usuario")
	private String userName;
	
	@JsonProperty(value = "email")
	private String email;
	
	@JsonProperty(value = "senha")
	private String password;
	
	private PessoaRequestDTO pessoaRequest;
	
	private List<QuestionarioRequestDTO> questionarioRequest;

	public Usuario toEntity() {
		Usuario usuario = new Usuario();
		try {
			ModelMapper mapper = new ModelMapper();
			usuario = mapper.map(this, Usuario.class);
		} catch (Exception e) {
			log.error("Erro ao mapear: {} para entidade: {}", this.getClass().getSimpleName(), Usuario.class.getSimpleName());
		}
		return usuario;
	} 
}
