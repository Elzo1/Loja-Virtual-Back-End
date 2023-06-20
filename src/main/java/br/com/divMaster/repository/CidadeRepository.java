package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
