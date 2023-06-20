package br.com.divMaster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divMaster.model.Marca;
import br.com.divMaster.repository.MarcaRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repository;
	
	public List<Marca> finAll(){
		return repository.findAll();
	}
	
	public Marca findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Marca Com id" +id+ "Não Encontrado"));
	}
	
	public Marca Criar( Marca marca) {
		marca.setDataCriacao(new Date());
			return repository.save(marca);
	}
	
	public Marca update( Marca marca) {
		var entity = repository.findById(marca.getId())
				.orElseThrow(()-> new unsupportedMathOperatioExceptio("Marca Não Encontrado"));
		
		entity.setNome(marca.getNome());
		entity.setDataAtualizacao(marca.getDataAtualizacao());
		
		marca.setDataAtualizacao(new Date());
		return repository.save(marca);
	}


	public void delete(Long id) {
		repository.deleteById(id);
	}

}
