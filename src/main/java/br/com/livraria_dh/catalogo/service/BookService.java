package br.com.livraria_dh.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.livraria_dh.catalogo.adapter.DozerAdapter;
import br.com.livraria_dh.catalogo.entity.Book;
import br.com.livraria_dh.catalogo.entity.vo.BookVO;
import br.com.livraria_dh.catalogo.exception.ResourceNotFoundException;
import br.com.livraria_dh.catalogo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;


	public List<BookVO> findAll() {
		return DozerAdapter.parseListObjects(repository.findAll(), BookVO.class);
	}

	public BookVO findById(Long id_bookVO) {
		var entity = repository.findById(id_bookVO)
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse Id"));
		return DozerAdapter.parseObject(entity, BookVO.class);
	}
	
//	public BookVO findByTitle(String title) {
//		var entity = repository.findBookByTitle(title);
//		return DozerAdapter.parseObject(entity, BookVO.class);
//	}

	public BookVO insert(BookVO book) {
		var entity = DozerAdapter.parseObject(book, Book.class);
		return DozerAdapter.parseObject(repository.save(entity), BookVO.class);
	}

	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getId_book())
				.orElseThrow(() -> new ResourceNotFoundException("Não foram encontrados registros com esse Id"));
		entity.setTitle(book.getTitle());
		entity.setIsbn(book.getIsbn());
//		entity.setCategory(bookVO.getCategory());
//		entity.setAuthors(bookVO.getAuthors());

		return DozerAdapter.parseObject(repository.save(entity), BookVO.class);
	}

	public void delete(Long id_book) {
		var entity = repository.findById(id_book)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado correpondência"));
		repository.delete(entity);
	}
}


































