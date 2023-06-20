package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
