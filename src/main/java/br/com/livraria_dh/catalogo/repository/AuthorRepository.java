package br.com.livraria_dh.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria_dh.catalogo.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
