package br.com.rede_social.presentation.dto.request;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.rede_social.domain.model.PeriodoSintoma;
import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.domain.model.Sintoma;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class QuestionarioRequestDTO {
	
	private List<Sintoma> sintomas;
	private PeriodoSintoma periodoSintoma;
	Integer idPessoa;
	
	public Questionario toEntity() {
		Questionario questionario = new Questionario();
		try {
			ModelMapper mapper = new ModelMapper();
			questionario = mapper.map(this, Questionario.class);
		} catch (Exception e) {
			log.error("Erro ao mapear: {} para entidade: {}", this.getClass().getSimpleName(), Questionario.class.getSimpleName());
		} 
		return questionario;
	} 

}
