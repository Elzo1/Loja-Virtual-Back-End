package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
