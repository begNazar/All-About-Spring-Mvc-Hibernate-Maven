package bookshelf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookshelf.DAO.BookDao;
import bookshelf.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	
	@Override
	public List<Book> getBooks() {
		// 
		return bookDao.getBooks();
	}

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveBook(Book theBook) {
		bookDao.saveBook(theBook);
		return "book saving process in Service implementation..."; 
	}

	@Override
	public Book updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book deleteBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
