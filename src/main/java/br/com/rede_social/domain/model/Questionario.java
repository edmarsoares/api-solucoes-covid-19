package br.com.rede_social.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 4246341855203264108L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_questionario_seq")
	@SequenceGenerator(name = "tb_questionario_seq", sequenceName = "tb_questionario_seq", allocationSize = 1)
	private Integer id;

	@CollectionTable
	@JoinTable(name = "tb_persontype", joinColumns = @JoinColumn(name = "persontypeid"))
	@Column(name = "persontype", nullable = false)
	@Enumerated(EnumType.STRING)
	private Sintoma sintomas;

	@Enumerated(EnumType.STRING)
	private PeriodoSintoma periodoSintoma;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Pessoa pessoa;
}
