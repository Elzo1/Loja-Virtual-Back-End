package br.com.divMaster.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.divMaster.model.Cidade;
import br.com.divMaster.service.CidadeService;


@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeService service;

	@GetMapping
	public List<Cidade> findAll() {
		return service.finAll();
	}

	@GetMapping("/{id}")
	public Cidade findById(@PathVariable("id")Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Cidade criate( @RequestBody Cidade cidade) {
		
		return service.Criar(cidade);
	}
	
	
	
	@PutMapping
	public Cidade update(@RequestBody Cidade cidade) {
		return service.update(cidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		service.delete(id);
	 return ResponseEntity.noContent().build();
	}
}
