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

import br.com.divMaster.model.Estado;
import br.com.divMaster.service.EstadoService;

@RestController
@RequestMapping("/api")
public class EstadoController {

	@Autowired
	private EstadoService service;

	@GetMapping
	public List<Estado> findAll() {
		return service.finAll();
	}

	@GetMapping("/{id}")
	public Estado findById(@PathVariable("id")Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Estado criate( @RequestBody Estado estado) {
		
		return service.criate(estado);
	}
	
	
	
	@PutMapping
	public Estado update(@RequestBody Estado estado) {
		return service.updade(estado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		service.delete(id);
	 return ResponseEntity.noContent().build();
	}
}
