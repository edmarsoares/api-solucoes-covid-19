package br.com.rede_social.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_questionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_questionario_seq")
	@SequenceGenerator(name = "tb_questionario_seq", sequenceName = "tb_questionario_seq", allocationSize = 1)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Sintoma sintomas;
	
	@Enumerated(EnumType.STRING)
	private PeriodoSintoma periodoSintoma;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Pessoa pessoa;
}
