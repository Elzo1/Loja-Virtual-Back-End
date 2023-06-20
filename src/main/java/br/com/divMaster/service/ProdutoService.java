package br.com.divMaster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divMaster.model.Produto;
import br.com.divMaster.repository.ProdutoRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> finAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Produto Com id" +id+ "Não Encontrado"));
	}
	
	public Produto criar( Produto produto) {
		produto.setDataCriacao(new Date());
			return repository.save(produto);
	}
	
	public Produto update( Produto produto) {
		var entity = repository.findById(produto.getId())
				.orElseThrow(()-> new unsupportedMathOperatioExceptio("Produto Não Encontrado"));
		
		entity.setNome(produto.getNome());
		entity.setDataCriacao(produto.getDataCriacao());
		entity.setDataAtualizacao(produto.getDataAtualizacao());
		
		produto.setDataAtualizacao(new Date());
		return repository.save(produto);
	}


	public void delete(Long id) {
		repository.deleteById(id);
	}

}
