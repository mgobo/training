package br.treinamento.compliance.web.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Nome nao pode ser vazio")
	@NotBlank(message = "Nome nao pode ser branco")
	@Size(min=1, max=255, message = "Nome nao pode ultrapassar 255 caracteres")
	private String nome;
	
	@NotEmpty(message = "Sexo nao pode ser vazio")
	@NotBlank(message = "Sexo nao pode ser branco")
	@Size(min=1, max=1, message = "Sexo nao pode ultrapassar 1 caracter")
	private String sexo;
	
	@NotEmpty(message = "Tipo Pessoa nao pode ser vazio")
	@NotBlank(message = "Tipo Pessoa nao pode ser branco")
	@Size(min=1, max=10, message = "Tipo Pessoa nao pode ultrapassar 10 caracteres")
	private String tipoPessoa;

	private FisicaDto fisicaDto;
	private JuridicaDto juridicaDto;
}
