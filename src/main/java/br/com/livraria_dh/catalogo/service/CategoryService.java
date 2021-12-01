package br.com.livraria_dh.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria_dh.catalogo.adapter.DozerAdapter;
import br.com.livraria_dh.catalogo.entity.Category;
import br.com.livraria_dh.catalogo.entity.vo.BookVO;
import br.com.livraria_dh.catalogo.entity.vo.CategoryVO;
import br.com.livraria_dh.catalogo.exception.ResourceNotFoundException;
import br.com.livraria_dh.catalogo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;

	public List<CategoryVO> findAll() {
		return DozerAdapter.parseListObjects(repository.findAll(), CategoryVO.class);
	}

	public CategoryVO findById(Long id_cat) {
		var entity = repository.findById(id_cat)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado correpondência"));
		return DozerAdapter.parseObject(entity, CategoryVO.class);
	}

	public CategoryVO insert(CategoryVO cat) {
		var entity = DozerAdapter.parseObject(cat, Category.class);
		return DozerAdapter.parseObject(repository.save(entity), CategoryVO.class);
	}

	public CategoryVO update(CategoryVO cat) {
		var entity = repository.findById(cat.getId_category())
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse Id"));
		entity.setName(cat.getName());

		return DozerAdapter.parseObject(repository.save(entity), CategoryVO.class);
	}

	public void delete(Long id_cat) {
		var entity = repository.findById(id_cat)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado correpondências"));
		repository.delete(entity);
	}
}























