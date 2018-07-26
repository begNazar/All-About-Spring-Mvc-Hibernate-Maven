package bookshelf.service;

import java.util.List;

import bookshelf.model.Book;

public interface BookService {

	public List<Book> getBooks();
	
	public Book getBook(int id);
	
	public String saveBook(Book book);
	
	public Book updateBook(int id, Book book);
	
	public Book deleteBook(int id);
}
