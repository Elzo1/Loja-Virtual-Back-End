package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
