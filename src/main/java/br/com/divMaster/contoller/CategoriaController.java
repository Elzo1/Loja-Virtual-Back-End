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

import br.com.divMaster.model.Categoria;
import br.com.divMaster.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public List<Categoria>findAll(){
		return service.finAll();
	}
	
	
	@GetMapping("/{id}")
	public Categoria findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Categoria criar(@RequestBody Categoria categoria) {
		return service.Criar(categoria);
	}
	
	@PutMapping
	public Categoria update(@RequestBody Categoria categoria) {
		return service.update(categoria);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable("id")Long id){
		 service.delete(id);
		 return ResponseEntity.noContent().build();
		
	}
}
