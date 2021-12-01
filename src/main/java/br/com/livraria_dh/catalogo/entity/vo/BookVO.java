package br.com.livraria_dh.catalogo.entity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import br.com.livraria_dh.catalogo.entity.Author;
import br.com.livraria_dh.catalogo.entity.Category;

public class BookVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id_book;

	private String title;

	private String isbn;

	private CategoryVO category;

	private List<AuthorVO> authors;

	public Long getId_book() {
		return id_book;
	}

	public void setId_book(Long id_book) {
		this.id_book = id_book;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public List<AuthorVO> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorVO> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authors, category, id_book, isbn, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		return Objects.equals(authors, other.authors) && Objects.equals(category, other.category)
				&& Objects.equals(id_book, other.id_book) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(title, other.title);
	}

}