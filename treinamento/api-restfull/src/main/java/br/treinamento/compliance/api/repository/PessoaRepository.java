package br.treinamento.compliance.api.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.treinamento.compliance.api.domain.Fisica;
import br.treinamento.compliance.api.domain.Juridica;
import br.treinamento.compliance.api.domain.Pessoa;
import br.treinamento.compliance.api.repository.impl.PessoaImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class PessoaRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final PessoaImpl pessoaImpl;

	public <S extends Pessoa> S saveAndFlush(S entity) {
		return pessoaImpl.saveAndFlush(entity);
	}

	public List<Pessoa> findAll() {
		return pessoaImpl.findAll();
	}

	public Optional<Pessoa> findById(Long id) {
		return pessoaImpl.findById(id);
	}

	public long count() {
		return pessoaImpl.count();
	}

	public void delete(Pessoa entity) {
		pessoaImpl.delete(entity);
	}
	
	public List<Pessoa> buscarPessoasAplicandoFiltro(Pessoa pessoa, EntityManager entityManager){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
		Root<Pessoa> from = cq.from(Pessoa.class);
		Join<Pessoa,Fisica> fisica 		= null;
		Join<Pessoa,Juridica> juridica 	= null;
		
		Predicate nome 		= cb.equal(from.get("pessoa.nome"), pessoa.getNome());
		Predicate pFisica 	= null;
		Predicate pJuridica	= null;
		if(pessoa.getFisica() != null && pessoa.getFisica().getCpf() != null) {
			fisica 	= from.join("pessoa.fisica");
			pFisica = cb.equal(fisica.get("fisica.cpf"),pessoa.getFisica().getCpf());
		} else {
			juridica = from.join("pessoa.juridica");
			pJuridica= cb.equal(juridica.get("juridica.cnpj"),pessoa.getJuridica().getCnpj());
		}		
		return pFisica != null ? entityManager.createQuery(cq.select(from).where(cb.and(nome,pFisica))).getResultList()
				: entityManager.createQuery(cq.select(from).where(cb.and(nome,pJuridica))).getResultList();
	}
}
