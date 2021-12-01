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
import br.com.livraria_dh.catalogo.entity.vo.CategoryVO;
import br.com.livraria_dh.catalogo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Category Endpoint")
@RestController
@RequestMapping("api/category/v1")
public class CategoryController {

	@Autowired
	CategoryService service;

	@Operation(summary = "Listar todos as categorias")
	@GetMapping(produces = { "application/json", "application/xml" })
	public List<CategoryVO> listCategories() {
		return service.findAll();
	}

	@Operation(summary = "Listar categoria passando o ID")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public CategoryVO findCategoryById(@PathVariable("id") Long idCat) {
		return service.findById(idCat);
	}

	@Operation(summary = "Inserir nova categoria")
	@PostMapping()
	public CategoryVO insert(@RequestBody CategoryVO cat) {
		return service.insert(cat);
	}
	
	@Operation(summary = "Atualizar informações da categoria passando o ID")
	@PutMapping(value = "/{id}", produces = { "application/json", "application/xml" }, consumes = { "application/json",
	"application/xml" })
	public CategoryVO update(@RequestBody CategoryVO category) {
		return service.update(category);
		
	}

	@Operation(summary = "Excluir categoria passando o ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryVO> delete(@PathVariable("id_cat") Long idCat) {
		service.delete(idCat);
		return ResponseEntity.ok().build();
	}
}
