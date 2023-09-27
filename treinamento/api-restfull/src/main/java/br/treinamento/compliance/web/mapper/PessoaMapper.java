package br.treinamento.compliance.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.treinamento.compliance.api.domain.Pessoa;
import br.treinamento.compliance.web.dto.PessoaDto;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

	@Mappings(value = {
			@Mapping(source = "fisicaDto",target = "fisica"),
			@Mapping(source = "juridicaDto",target = "juridica"),
	})	
	Pessoa toEntity(PessoaDto pessoaDto);
	
	@Mappings(value = {
			@Mapping(source = "fisica",target = "fisicaDto"),
			@Mapping(source = "juridica",target = "juridicaDto"),
	})
	PessoaDto toDto(Pessoa pessoa);
	
}
