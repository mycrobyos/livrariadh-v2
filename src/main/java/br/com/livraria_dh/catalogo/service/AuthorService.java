package br.com.livraria_dh.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria_dh.catalogo.adapter.DozerAdapter;
import br.com.livraria_dh.catalogo.entity.Author;
import br.com.livraria_dh.catalogo.entity.Book;
import br.com.livraria_dh.catalogo.entity.vo.AuthorVO;
import br.com.livraria_dh.catalogo.entity.vo.BookVO;
import br.com.livraria_dh.catalogo.exception.ResourceNotFoundException;
import br.com.livraria_dh.catalogo.repository.AuthorRepository;
import br.com.livraria_dh.catalogo.repository.BookRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repository;

	public List<AuthorVO> findAll() {
		return DozerAdapter.parseListObjects(repository.findAll(), AuthorVO.class);
	}

	public AuthorVO findById(Long id_authorVO) {
		var entity = repository.findById(id_authorVO)
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse Id"));
		return DozerAdapter.parseObject(entity, AuthorVO.class);
	}

	public AuthorVO insert(AuthorVO aut) {
		var entity = DozerAdapter.parseObject(aut, Author.class);
		return DozerAdapter.parseObject(repository.save(entity), AuthorVO.class);
	}

	public AuthorVO update(AuthorVO aut) {
		var entity = repository.findById(aut.getId_author())
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse Id"));
		entity.setName(aut.getName());
		entity.setBio(aut.getBio());
		return DozerAdapter.parseObject(repository.save(entity), AuthorVO.class);
	}

	public void delete(Long id_aut) {
		var entity = repository.findById(id_aut)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado correpondência"));
		repository.delete(entity);
	}
}

































