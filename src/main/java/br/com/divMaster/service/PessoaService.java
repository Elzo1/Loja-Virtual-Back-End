package br.com.divMaster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divMaster.model.Pessoa;
import br.com.divMaster.repository.PessoaRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> finAll(){
		return repository.findAll();
	}
	
	public Pessoa findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Pessoa Com id" +id+ "Não Encontrado"));
	}
	
	public Pessoa Criar( Pessoa pessoa) {
		pessoa.setDataCriacao(new Date());
			return repository.save(pessoa);
	}
	
	public Pessoa update( Pessoa pessoa) {
		var entity = repository.findById(pessoa.getId())
				.orElseThrow(()-> new unsupportedMathOperatioExceptio("Pessoa Não Encontrado"));
		
		entity.setNome(pessoa.getNome());
		entity.setDataAtualizacao(pessoa.getDataAtualizacao());
		
		pessoa.setDataAtualizacao(new Date());
		return repository.save(pessoa);
	}


	public void delete(Long id) {
		repository.deleteById(id);
	}

}
