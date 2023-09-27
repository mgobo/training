package br.treinamento.compliance.api.domain;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1, initialValue = 1)
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "pessoa_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String nome;
	
	@Column(length = 1)
	private String sexo;
	
	@Column(nullable = false, length = 10)
	private String tipoPessoa;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private Fisica fisica;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private Juridica juridica;
	
}
