package javarest_jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MockPersistence {

	
	private static List<Book> books = new ArrayList<Book>();
	private static List<Author> authors = new ArrayList<Author>();
	
	
	public static void addBook(Book b) {
		create(b);
	}
	

	public static List<Book> getBooks() {
		return books;
	}
	
	public static List<Book> getBooksByAuthor(Author author) {
		return books.stream().filter(b -> b.getAuthor() == author).collect(Collectors.toList());
	}
	
	public static Book getBook(int id) {
		return books.stream().filter(b -> b.getId() == id).findAny().orElse(null);
	}

	public static void create(Book b) {
		System.out.println("Adding a book: "+b);
		books.add(b);
		System.out.println("Looking for an author");
		Author currentAuthor = getAuthor(b.getAuthor().getId());
		System.out.println("currentAuthor: "+currentAuthor+" "+b.getAuthor()+" "+b);
		if (currentAuthor == null) {
			System.out.println("Adding "+b.getAuthor());
			authors.add(b.getAuthor());
		}
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
	
	public static Author getAuthorByName(String firstName, String lastName) {
		//return authors.stream().filter(b -> b.getFirstName().equals(firstName) && b.getLastName().equals(lastName)).findAny().orElse(null);
		return authors.stream().filter(b -> b.getFirstName()==firstName && b.getLastName()==lastName).findAny().orElse(null);
	}
	
	
	// Creation of authors is done via a book
	
	public static List<Author> getAuthors() {
		return authors;
	}
	
	public static Author getAuthor(int id) {
		return authors.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
	}
	
	public static Author getAuthorFromBook(String firstName) {
		Optional<Book> tempBooks = books.stream().filter(book -> book.getAuthors().stream()
				.anyMatch(author -> author.getFirstName().equals(firstName))).findAny();
		if (tempBooks.isPresent()) {
			return tempBooks.get().getAuthors().stream().filter(author -> author.getFirstName().equals(firstName)).findFirst().orElse(null);	
		}
		return null;
	}
	

	public static List<Author> updateAuthor(int id, Author updatedAuthor) {
		Author currentAuthor = getAuthor(id);
		if (currentAuthor != null) {
			currentAuthor.updateAuthor(updatedAuthor);
		}
		return authors;
	}
	
	
	public static List<Author> deleteAuthor(int id) {
		Author author = getAuthor(id);
		if (author != null ) {
			for(Book book : author.getBooks()) {
				books.removeIf(b -> b.getId() == book.getId());	
			}
			authors.removeIf(b -> b.getId() == id);	
		}
		return authors;
	}

}
