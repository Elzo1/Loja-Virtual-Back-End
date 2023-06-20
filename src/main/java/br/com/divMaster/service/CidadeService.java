package br.com.divMaster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divMaster.model.Cidade;
import br.com.divMaster.repository.CidadeRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> finAll(){
		return repository.findAll();
	}
	
	public Cidade findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Cidade Com id" +id+ "Não Encontrado"));
	}
	
	public Cidade Criar( Cidade cidade) {
		cidade.setDataCriacao(new Date());
			return repository.save(cidade);
	}
	
	public Cidade update( Cidade cidade) {
		var entity = repository.findById(cidade.getId())
				.orElseThrow(()-> new unsupportedMathOperatioExceptio("Cidade Não Encontrado"));
		
		entity.setNome(cidade.getNome());
		entity.setDataAtualizacao(cidade.getDataAtualizacao());
		
		cidade.setDataAtualizacao(new Date());
		return repository.save(cidade);
	}


	public void delete(Long id) {
		repository.deleteById(id);
	}


}
