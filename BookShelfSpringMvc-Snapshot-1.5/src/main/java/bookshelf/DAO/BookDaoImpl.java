package bookshelf.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bookshelf.model.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		
		List<Book> theBooks;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Book> theQuery = 
				currentSession.createQuery("from Book order by firstName",
						Book.class);
		
		theBooks = theQuery.getResultList();
		
		
		return theBooks;
	}

	@Override
	public Book getBook(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve data from database using the primary key
		Book theBook = currentSession.get(Book.class, theId);
		
		return theBook;
	}

	@Override
	public String saveBook(Book theBook) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the book
		currentSession.saveOrUpdate(theBook);
		
		return "book saving process in bookDAO - tier Almost done..";
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
