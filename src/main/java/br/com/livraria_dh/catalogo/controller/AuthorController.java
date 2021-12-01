package br.com.livraria_dh.catalogo.controller;

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

import br.com.livraria_dh.catalogo.entity.vo.AuthorVO;
import br.com.livraria_dh.catalogo.entity.vo.BookVO;
import br.com.livraria_dh.catalogo.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Author Endpoint")
@RestController
@RequestMapping("api/author/v1")
public class AuthorController {

	@Autowired
	AuthorService service;
	
	@Operation(summary = "Listar todos os autores")
	@GetMapping(produces = { "application/json", "application/xml" })
	public List<AuthorVO> listAuthors() {
		return service.findAll();
	}
	
	@Operation(summary = "Listar autor passando o ID")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public AuthorVO listAuthorById(@PathVariable("id") Long idAuthor) {
		return service.findById(idAuthor);
	}

	@Operation(summary = "Inserir novo autor")
	@PostMapping()
	public AuthorVO insert(@RequestBody AuthorVO aut) {
		return service.insert(aut);
	}

	@Operation(summary = "Atualizar dados do autor passando o ID")
	@PutMapping(value = "/{id}", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public AuthorVO update(@RequestBody AuthorVO aut) {
		return service.update(aut);
	}
	
	@Operation(summary = "Excluir um autor passando o ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<AuthorVO> delete(@PathVariable("id") Long idAuthor) {
		service.delete(idAuthor);
		return ResponseEntity.ok().build();
	}
}

























