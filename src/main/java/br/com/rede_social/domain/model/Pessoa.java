package br.com.rede_social.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_pessoa")
public class Pessoa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_pessoa_seq")
	@SequenceGenerator(name = "tb_pessoa_seq", sequenceName = "tb_pessoa_seq", allocationSize = 1)
	private Integer id;
	private String nomeCompleto;
	private String celular;
	private Sexo sexo;
	private LocalDate dataNascimento;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
}
