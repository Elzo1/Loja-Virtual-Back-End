package br.com.divMaster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divMaster.model.Categoria;
import br.com.divMaster.repository.CategoriaRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> finAll(){
		return repository.findAll();
	}

	
	public Categoria findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Categoria Não Encontrad"));
	}
	
	public Categoria Criar(Categoria categoria) {
		categoria.setDateCriacao(new Date());
		return repository.save(categoria);
	}
	
	public Categoria update(Categoria categoria) {
		var entity = repository.findById(categoria.getId())
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Categoria Não Encontrad"));
		entity.setNome(categoria.getNome());
		entity.setDateCriacao(categoria.getDateCriacao());
		entity.setDataAtualizacao(categoria.getDataAtualizacao());
		categoria.setDataAtualizacao(new Date());
		return repository.save(categoria);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
