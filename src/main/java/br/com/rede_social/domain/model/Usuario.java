package br.com.rede_social.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuario_seq")
	@SequenceGenerator(name = "tb_usuario_seq", sequenceName = "tb_usuario_seq", allocationSize = 1)
	private Integer id;
	private String userName;
	private String email;
	private String password;
}
