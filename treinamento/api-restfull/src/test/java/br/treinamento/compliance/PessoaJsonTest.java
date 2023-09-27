package br.treinamento.compliance;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.treinamento.compliance.api.domain.Fisica;
import br.treinamento.compliance.api.domain.Pessoa;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PessoaJsonTest {

	@Test
	void criarJsonPessoaTest() throws JsonProcessingException {
		
		Pessoa p = Pessoa.builder().nome("VANVAN BABILONICO")
				.sexo("M")
				.tipoPessoa("FISICA")
				.fisica(Fisica.builder().cpf("24242242424").build())
				.build();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);
		log.info(json);
	}
	
}
