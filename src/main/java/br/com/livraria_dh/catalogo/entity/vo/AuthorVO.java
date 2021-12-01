package br.com.livraria_dh.catalogo.entity.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthorVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id_author;

	private String name;

	private String bio;

	@JsonIgnore
	private List<BookVO> books;

	public Long getId_author() {
		return id_author;
	}

	public void setId_author(Long id_author) {
		this.id_author = id_author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

//	public List<BookVO> getBooks() {
//		return books;
//	}
//
//	public void setBooks(List<BookVO> books) {
//		this.books = books;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(bio, books, id_author, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorVO other = (AuthorVO) obj;
		return Objects.equals(bio, other.bio) && Objects.equals(books, other.books)
				&& Objects.equals(id_author, other.id_author) && Objects.equals(name, other.name);
	}

}