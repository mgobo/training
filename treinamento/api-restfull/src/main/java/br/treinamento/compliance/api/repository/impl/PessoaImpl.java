package br.treinamento.compliance.api.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import br.treinamento.compliance.api.domain.Pessoa;

public interface PessoaImpl extends JpaRepository<Pessoa, Long>{

}
