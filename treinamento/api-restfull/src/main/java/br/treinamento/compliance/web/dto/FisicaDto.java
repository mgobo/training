package br.treinamento.compliance.web.dto;

import java.io.Serializable;

import br.treinamento.compliance.api.domain.Pessoa;
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
public class FisicaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Cpf nao pode ser vazio")
	@NotBlank(message = "Cpf nao pode ser branco")
	@Size(min=1, max=11, message = "Cpf nao pode ultrapassar 11 caracteres")
	private String cpf;	
	private Pessoa pessoa;
}
