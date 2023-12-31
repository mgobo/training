package br.treinamento.compliance.api.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.treinamento.compliance.api.domain.Fisica;
import br.treinamento.compliance.api.domain.Juridica;
import br.treinamento.compliance.api.domain.Pessoa;
import br.treinamento.compliance.api.repository.PessoaRepository;
import br.treinamento.compliance.web.dto.FilterPessoaDto;
import br.treinamento.compliance.web.dto.PessoaDto;
import br.treinamento.compliance.web.mapper.PessoaMapperImpl;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService implements Serializable{
	
	private final static long serialVersionUID = 1l;
	private final PessoaRepository pessoaRepository;
	private final PessoaMapperImpl pessoaMapperImpl;
	private final EntityManager entityManager;
	
	public List<PessoaDto> aplicarFiltroBuscaPessoa(FilterPessoaDto filterPessoaDto){
		Fisica fisica = null;
		Juridica juridica = null;
		if(filterPessoaDto.getDocumento().length() == 11) {
			fisica = new Fisica();
			fisica.setCpf(filterPessoaDto.getDocumento());			
		} else {
			juridica = new Juridica();
			juridica.setCnpj(filterPessoaDto.getDocumento());
		}
		Pessoa p = new Pessoa();
		p.setNome(filterPessoaDto.getNome());
		p.setFisica(fisica);
		p.setJuridica(juridica);
		p.setSexo(filterPessoaDto.getSexo());
		
		List<Pessoa> pessoaCollection = this.pessoaRepository.buscarPessoasAplicandoFiltro(p, this.entityManager);
		List<PessoaDto> pessoaCollectionDto = new ArrayList<>();
		
		pessoaCollection.stream().forEach(pessoa->{
			pessoaCollectionDto.add(this.pessoaMapperImpl.toDto(pessoa));
		});		
		return pessoaCollectionDto;
	}

}
