package br.com.rede_social.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = -286282886535469086L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_pessoa_seq")
	@SequenceGenerator(name = "tb_pessoa_seq", sequenceName = "tb_pessoa_seq", allocationSize = 1)
	@Column(name = "Id_Pessoa")
	private Integer id;
	
	@NotBlank(message = "nome não pode ser nulo")
	private String nomeCompleto;
	
	@NotBlank(message = "nome não pode ser nulo")
	private String celular;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column
	private LocalDate dataNascimento;
	
//	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//	@JoinColumn(name = "id_usuario")
//	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Questionario> questionario;
	
	private Boolean flagInteresseAuxilioPesuisas;
}
