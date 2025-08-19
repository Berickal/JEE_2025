package jsf.repository;

import java.util.ArrayList;
import java.util.List;

import jsf.beans.Book;

public class BookRepository {
	private static List<Book> books = new ArrayList<>();
    private static int counter = 1;

    public void addBook(Book book) {
        book.setId(counter++);
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }
    
    
}
