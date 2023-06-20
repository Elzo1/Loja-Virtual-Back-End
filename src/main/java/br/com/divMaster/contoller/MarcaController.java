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

import br.com.divMaster.model.Marca;
import br.com.divMaster.service.MarcaService;


@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService service;
	
	@GetMapping
	public List<Marca>findAll(){
		return service.finAll();
	}
	
	
	@GetMapping("/{id}")
	public Marca findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Marca criar(@RequestBody Marca marca) {
		return service.Criar(marca);
	}
	
	@PutMapping
	public Marca update(@RequestBody Marca marca) {
		return service.update(marca);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable("id")Long id){
		 service.delete(id);
		 return ResponseEntity.noContent().build();
		
	}
}
