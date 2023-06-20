package br.com.divMaster.contoller;

import java.util.Date;
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

import br.com.divMaster.model.Pessoa;
import br.com.divMaster.service.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	public List<Pessoa>findAll(){
		return service.finAll();
	}
	@GetMapping("/{id}")
	public Pessoa findById(@PathVariable("id") Long  id) {
		return service.findById(id);
				
	}
	
	@PostMapping
	public Pessoa criar(@RequestBody Pessoa pessoa) {
		pessoa.setDataCriacao(new Date());
		return service.Criar(pessoa);
	}
	
	@PutMapping
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return service.update(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
