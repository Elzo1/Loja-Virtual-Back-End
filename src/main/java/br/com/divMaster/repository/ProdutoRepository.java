package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
