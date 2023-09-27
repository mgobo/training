package br.treinamento.compliance.web.mapper;

import org.mapstruct.Mapper;

import br.treinamento.compliance.api.domain.Fisica;
import br.treinamento.compliance.web.dto.FisicaDto;

@Mapper(componentModel = "spring")
public interface FisicaMapper {

//	@Mapping(source = "documento", target = "cpf")
	Fisica toEntity(FisicaDto fisicaDto);
	
//	@Mapping(source = "cpf", target = "documento")
	FisicaDto toDto(Fisica fisica);
	
}
