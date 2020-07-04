package br.com.rede_social.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.CollectionType;

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
	
	@ElementCollection(targetClass = Sintoma.class)
	@JoinTable(name = "t_sintoma", joinColumns = @JoinColumn(name = "id_questionario"))
	@Column(name = "sintoma", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Sintoma> sintomas;
	
	@Enumerated(EnumType.STRING)
	private PeriodoSintoma periodoSintoma;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Pessoa pessoa;
}
