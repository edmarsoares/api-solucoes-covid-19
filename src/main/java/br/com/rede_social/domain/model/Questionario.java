package br.com.rede_social.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_questionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionario implements Serializable {

	private static final long serialVersionUID = 4246341855203264108L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_questionario_seq")
	@SequenceGenerator(name = "tb_questionario_seq", sequenceName = "tb_questionario_seq", allocationSize = 1)
	private Integer id;
	
	@ElementCollection(targetClass = Sintoma.class, fetch = FetchType.EAGER)
	@JoinTable(name = "t_sintoma", joinColumns = @JoinColumn(name = "id_questionario"))
	@Column(name = "sintoma", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Sintoma> sintomas;
	
	@Enumerated(EnumType.STRING)
	private PeriodoSintoma periodoSintoma;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@CreationTimestamp
	private LocalDateTime dataQuestionario;
	
}
