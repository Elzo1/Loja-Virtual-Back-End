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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.divMaster.model.ImagensProduto;
import br.com.divMaster.service.ImagensProdutoService;

@RestController
@RequestMapping("/img")
public class ImagemProdutoController {

	@Autowired
	private ImagensProdutoService service;

	@GetMapping
	public List<ImagensProduto> findAll() {
		return service.finAll();
	}

	@GetMapping("/{id}")
	public ImagensProduto findById(@PathVariable("id")Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ImagensProduto criate(@RequestParam("produtoId") Long produtoId, 
			                     @RequestParam("file") MultipartFile file) {
		return  service.criar(produtoId, file);
	}
	
	
	
	@PutMapping
	public ImagensProduto update(@RequestBody ImagensProduto imagensProduto) {
		return service.update(imagensProduto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		service.delete(id);
	 return ResponseEntity.noContent().build();
	}
}
