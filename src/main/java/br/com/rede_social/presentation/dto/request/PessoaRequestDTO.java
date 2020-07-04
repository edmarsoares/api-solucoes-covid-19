package br.com.rede_social.presentation.dto.request;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import br.com.rede_social.domain.model.Pessoa;
import br.com.rede_social.domain.model.Sexo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PessoaRequestDTO {
	
	private String nomeCompleto;
	private String celular;
	private Sexo sexo;
	private LocalDate dataNascimento;
	
	public Pessoa toEntity() {
		Pessoa pessoa = new Pessoa();
		try {
			ModelMapper mapper = new ModelMapper();
			pessoa = mapper.map(this, Pessoa.class);
		} catch (Exception e) {
			log.error("Erro ao mapear: {} para entidade: {}", this.getClass().getSimpleName(), Pessoa.class.getSimpleName());
		}
		return pessoa;
	} 
}
