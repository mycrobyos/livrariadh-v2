package br.com.livraria_dh.catalogo.entity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id_category;

	private String name;
	
	@JsonIgnore
	private List<BookVO> books;

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookVO> getBooks() {
		return books;
	}

	public void setBooks(List<BookVO> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		return Objects.hash(books, id_category, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryVO other = (CategoryVO) obj;
		return Objects.equals(books, other.books) && Objects.equals(id_category, other.id_category)
				&& Objects.equals(name, other.name);
	}

}