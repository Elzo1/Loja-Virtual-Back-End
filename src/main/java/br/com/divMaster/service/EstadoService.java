package br.com.divMaster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divMaster.model.Estado;
import br.com.divMaster.repository.EstadoRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> finAll(){
		return repository.findAll();
	}
	
	public Estado findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Estado Com id" +id+ "Não Encontrado"));
	}
	
	public Estado criate( Estado estado) {
		estado.setDataCriacao(new Date());
			return repository.save(estado);
	}
	
	public Estado updade( Estado estado) {
		var entity = repository.findById(estado.getId())
				.orElseThrow(()-> new unsupportedMathOperatioExceptio("Estado Não Encontrado"));
		
		entity.setNome(estado.getNome());
		entity.setSigla(estado.getSigla());
		entity.setDataAtualizacao(estado.getDataAtualizacao());
		
		estado.setDataAtualizacao(new Date());
		return repository.save(estado);
	}


	public void delete(Long id) {
		repository.deleteById(id);
	}



}
