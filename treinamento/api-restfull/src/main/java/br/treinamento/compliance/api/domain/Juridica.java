package br.treinamento.compliance.api.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "juridica")
@SequenceGenerator(name = "juridica_seq", sequenceName = "juridica_seq", allocationSize = 1, initialValue = 1)
public class Juridica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "juridica_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@JoinColumn(name = "pessoa_id")
	@OneToOne
	private Pessoa pessoa;
	
	@Column(nullable = false, length = 14)
	private String cnpj;

}
