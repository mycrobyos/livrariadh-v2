package br.com.livraria_dh.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria_dh.catalogo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
