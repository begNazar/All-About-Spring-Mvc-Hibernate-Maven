package bookshelf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="book_title")
	private String bookTitle;
	
	@Column(name="book_category")
	private String category;
	
	@Column(name="edition_version")
	private String editionVersion;
	
	
	private Author author;
	
	 public Book() {
		// no-arg constructor!
	}

	public Book(int id, String bookTitle, String category, String editionVersion) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.category = category;
		this.editionVersion = editionVersion;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEditionVersion() {
		return editionVersion;
	}

	public void setEditionVersion(String editionVersion) {
		this.editionVersion = editionVersion;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	 
	 
	 
}
