package javarest_jersey;

import java.util.ArrayList;
import java.util.List;

public class PersistantBook {

	
	private static List<Book> books = new ArrayList<Book>();
	
	
	public static void addBook(Book b) {
		books.add(b);
	}
	

	public static List<Book> getBooks() {
		return books;
	}
	
	public static Book getBook(int id) {
		return books.stream().filter(b -> b.getId() == id).findAny().orElse(null);
	}

	public static void create(Book b) {
		books.add(b);
	}

	public static List<Book> updateBook(int id, Book updatedBook) {
		Book currentBook = getBook(id);
		if (currentBook != null) {
			currentBook.updateBook(updatedBook);
		}
		return books;
	}

	public static List<Book> deleteBook(int id) {
		books.removeIf(b -> b.getId() == id);
		return books;
	}

}
