package br.com.divMaster.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.divMaster.model.ImagensProduto;
import br.com.divMaster.model.Produto;
import br.com.divMaster.repository.ImagensProdutoRepository;
import br.com.divMaster.repository.ProdutoRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class ImagensProdutoService {

	@Autowired
	private ImagensProdutoRepository repository;

	@Autowired
	private ProdutoRepository repositori;

	public List<ImagensProduto> finAll() {
		return repository.findAll();
	}

	public ImagensProduto findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new unsupportedMathOperatioExceptio("ImagensProduto Com id" + id + "Não Encontrado"));
	}

	public ImagensProduto criar(Long produtoId, MultipartFile file) {
		Produto produto = repositori.findById(produtoId).get();
		ImagensProduto novoProdutoImg = new ImagensProduto();

		try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				String nomeImg = String.valueOf(produto.getId()) + file.getOriginalFilename();
				Path caminho = Paths.get("c:/imagens/" + nomeImg);
				Files.write(caminho, bytes);
				novoProdutoImg.setNome(nomeImg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		novoProdutoImg.setDataCriacao(new Date());
		novoProdutoImg.setProduto(produto);
		return repository.save(novoProdutoImg);

	}

	public ImagensProduto update(ImagensProduto imagensProduto) {
		var entity = repository.findById(imagensProduto.getId())
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("ImagensProduto Não Encontrado"));

		entity.setNome(imagensProduto.getNome());
		entity.setDataAtualizacao(imagensProduto.getDataAtualizacao());

		imagensProduto.setDataAtualizacao(new Date());
		return repository.save(imagensProduto);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	
	}
}
