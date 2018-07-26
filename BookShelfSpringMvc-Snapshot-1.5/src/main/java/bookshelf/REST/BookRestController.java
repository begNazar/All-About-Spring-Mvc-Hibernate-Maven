package bookshelf.REST;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookshelf.model.Book;
import bookshelf.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {

	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	private List<Book> theBooks;
	
	// define @PostConstruct to load the book data only once!
	
	@PostConstruct
	public void loadBooksData() {

		theBooks = new ArrayList<>();
		
		theBooks.add(new Book(1, "The Big Bang", "fantastic", "Second Edition"));
		theBooks.add(new Book(2, "Hayvanat Bahcesi", "bilim kurgu", "fifth Edition"));
		theBooks.add(new Book(3, "Orumcek aglar", "fantastic", "third Edition"));
		
		
	}

	@GetMapping(path="/books", produces = "application/json")
	public List<Book> getBooks(){
		
		return bookService.getBooks();
	}

	@GetMapping(path="/books/{bookId}", produces="application/json")
	public Book getBook(@PathVariable int bookId) {
		
		return theBooks.get(bookId);
	}

	@PostMapping("/books")
	public String saveBook(@RequestBody Book theBook) {
		
		theBook.setId(0);
		
		bookService.saveBook(theBook);
		
		return "book saving process in REST-Controller";
		
	}
	
	@PutMapping("/books")
	public Book UpdateBook(@RequestBody Book theBook) {
		
		bookService.saveBook(theBook);
		
		return theBook;
	}
	
	
	
}




