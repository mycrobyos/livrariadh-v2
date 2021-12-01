package br.com.livraria_dh.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.livraria_dh.catalogo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//	@Query("SELECT b FROM Book b WHERE b.name LIKE LOWER(CONCAT ('%', :name ,'%'))")
//	Page<Book> findBookByName(@Param("name") String name);
	
	@Query("SELECT b FROM Book b WHERE b.title LIKE LOWER(CONCAT ('%', :title ,'%'))")
	List<Book> findBookByTitle(@Param("title") String title);

}
