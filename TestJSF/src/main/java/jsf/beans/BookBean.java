package jsf.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jsf.repository.BookRepository;

import java.io.Serializable;
import java.util.List;

@Named("bookBean")
@SessionScoped        
public class BookBean implements Serializable {

    private static final long serialVersionUID = 1L;
	private BookRepository dao = new BookRepository();  // DAO for CRUD
    private Book book = new Book();       // Holds the form input (new book)

    // Add book and redirect to list page
    public String addBook() {
        dao.addBook(book);
        book = new Book(); // reset form
        return "listBooks?faces-redirect=true"; // navigate to list
    }

    // Get all books (for dataTable)
    public List<Book> getBooks() {
        return dao.getAllBooks();
    }

    // Delete book
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    // Getters/Setters
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}

