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
public class FilterPessoaDto implements Serializable {

	private final static long serialVersionUID = 1l;
	
	@NotEmpty(message = "Nome nao pode ser vazio")
	@NotBlank(message = "Nome nao pode ser branco")
	@Size(min=1, max=255, message = "Nome nao pode ultrapassar 255 caracteres")
	private String nome;
	
	@NotEmpty(message = "Documento nao pode ser vazio")
	@NotBlank(message = "Documento nao pode ser branco")
	@Size(min=1, max=14, message = "Documento nao pode ultrapassar 14 caracteres")
	private String documento;
	private String sexo;
}
