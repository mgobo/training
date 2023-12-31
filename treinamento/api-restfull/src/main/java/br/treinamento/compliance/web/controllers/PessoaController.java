package br.treinamento.compliance.web.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.treinamento.compliance.api.domain.Fisica;
import br.treinamento.compliance.api.domain.Juridica;
import br.treinamento.compliance.api.domain.Pessoa;
import br.treinamento.compliance.api.repository.PessoaRepository;
import br.treinamento.compliance.api.services.PessoaService;
import br.treinamento.compliance.web.dto.FilterPessoaDto;
import br.treinamento.compliance.web.dto.PessoaDto;
import br.treinamento.compliance.web.mapper.FisicaMapperImpl;
import br.treinamento.compliance.web.mapper.JuridicaMapperImpl;
import br.treinamento.compliance.web.mapper.PessoaMapperImpl;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping(value = "/api/v1/pessoa")
@RequiredArgsConstructor
public class PessoaController {
	
	private final PessoaService pessoaService;
	private final PessoaRepository pessoaRepository;
	private final PessoaMapperImpl pessoaMapperImpl;
	private final FisicaMapperImpl fisicaMapperImpl;
	private final JuridicaMapperImpl juridicaMapperImpl;
	
	
	@GetMapping
	public ResponseEntity<Object> findAll(){
		try {
			final List<PessoaDto> pessoaDtoCollection = new ArrayList<>();
			List<Pessoa> pessoaCollection = this.pessoaRepository.findAll();
			pessoaCollection.stream().forEach(p->{
				PessoaDto pessoaDto = this.pessoaMapperImpl.toDto(p);
				if(p.getFisica() != null) {
					pessoaDto.setFisicaDto(this.fisicaMapperImpl.toDto(p.getFisica()));
				}else {
					pessoaDto.setJuridicaDto(this.juridicaMapperImpl.toDto(p.getJuridica()));
				}
				pessoaDtoCollection.add(pessoaDto);
			});
			return ResponseEntity.ok().body(pessoaDtoCollection);
		}catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro interno no processamento da requisicao");
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> findByFilters(@Validated @RequestBody FilterPessoaDto filterPessoaDto){
		try {			
			return ResponseEntity.ok().body(this.pessoaService.aplicarFiltroBuscaPessoa(filterPessoaDto));
		}catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro interno no processamento da requisicao");
		}
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> count(){
		return ResponseEntity.ok(this.pessoaRepository.count());
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<PessoaDto> findById(@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(this.pessoaMapperImpl.toDto(pessoaRepository.findById(id).get()));
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create-pessoa")
	public ResponseEntity<Object> createPessoa(@Validated @RequestBody PessoaDto pessoaDto){
		try {
			Pessoa pessoa = this.pessoaMapperImpl.toEntity(pessoaDto);
			if(pessoaDto.getFisicaDto() != null) {
				Fisica fisica = pessoa.getFisica();
				fisica.setPessoa(pessoa);
				
				pessoa.setFisica(fisica);
			}else {
				Juridica juridica = pessoa.getJuridica();
				juridica.setPessoa(pessoa);
				
				pessoa.setJuridica(juridica);
			}			
			pessoa = this.pessoaRepository.saveAndFlush(pessoa);
			return ResponseEntity.created(new URI(String.format("/api/v1/pessoa/findById/%s",pessoa.getId()))).build();
		}catch(Exception ex) {
			return ResponseEntity.badRequest().body(String.format("Problemas na inclusao de um novo registro de pessoa. [Erro] = %s", ex.getMessage()));
		}
	}
}
