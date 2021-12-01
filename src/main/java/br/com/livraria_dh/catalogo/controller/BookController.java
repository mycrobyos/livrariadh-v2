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

import br.com.livraria_dh.catalogo.entity.vo.BookVO;
import br.com.livraria_dh.catalogo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book Endpoint")
@RestController
@RequestMapping("api/book/v1")
public class BookController {

	@Autowired
	BookService service;

	@Operation(summary = "Listar todos os livros")
	@GetMapping(produces = { "application/json", "application/xml" })
	public List<BookVO> listBooks() {
		return service.findAll();
	}

	@Operation(summary = "Listar livro passando o ID")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public BookVO listBookById(@PathVariable("id") Long idBook) {
		return service.findById(idBook);
	}

//	@Operation(summary = "Listar livro passando o título")
//	@GetMapping(produces = { "application/json", "application/xml" })
//	public BookVO findBookByTitle(@RequestBody String book) {
//		return service.findByTitle(book);
//	}

	@Operation(summary = "Inserir um novo livro")
	@PostMapping()
	public BookVO insert(@RequestBody BookVO book) {
		return service.insert(book);
	}

	@Operation(summary = "Atualizar as informações de um livro passando o ID")
	@PutMapping(value = "/{id}", produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}

	@Operation(summary = "Excluir um livro do catálogo passando o ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<BookVO> delete(@PathVariable("id") Long idBook) {
		service.delete(idBook);
		return ResponseEntity.ok().build();
	}

}
