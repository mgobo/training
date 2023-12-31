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
public class JuridicaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Cnpj nao pode ser vazio")
	@NotBlank(message = "Cnpj nao pode ser branco")
	@Size(min=1, max=14, message = "Cnpj nao pode ultrapassar 14 caracteres")
	private String cnpj;	
	private Pessoa pessoa;
}
