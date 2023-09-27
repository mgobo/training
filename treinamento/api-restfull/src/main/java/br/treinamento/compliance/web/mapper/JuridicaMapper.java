package br.treinamento.compliance.web.mapper;

import org.mapstruct.Mapper;

import br.treinamento.compliance.api.domain.Juridica;
import br.treinamento.compliance.web.dto.JuridicaDto;

@Mapper(componentModel = "spring")
public interface JuridicaMapper {

	Juridica toEntity(JuridicaDto juridicaDto);
	JuridicaDto toDto(Juridica juridica);
	
}
