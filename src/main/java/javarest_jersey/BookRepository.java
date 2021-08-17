package javarest_jersey;

import java.util.List;

public class BookRepository {
	
//private List<Book> books;

public BookRepository() {
	if (PersistantBook.getBooks() ==null || PersistantBook.getBooks().size()==0) {
		System.out.println("Generating initial books");
		
		// books = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setName("To Kill a Mockingbird");
		book1.setId(100);
		book1.setIsbn("A1B2C3");
		book1.setStockTotal(10);
		
		Book book2 = new Book(101, "Beloved", "A2B2C3", 20);
		// books.add(book1);
		// books.add(book2);
		
		PersistantBook.addBook(book1);
		PersistantBook.addBook(book2);
		System.out.println(" PB - "+PersistantBook.getBooks().size());
	
	}
		
}

public List<Book> getBooks() {
	return PersistantBook.getBooks();
	//return books;
}

public Book getBook(int id) {
	return PersistantBook.getBook(id);
	//return books.stream().filter(b -> b.getId() == id).findAny().orElse(null);
}

public void create(Book b) {
	PersistantBook.create(b);
	//books.add(b);
}

public List<Book> updateBook(int id, Book updatedBook) {
	
		
	return PersistantBook.updateBook(id, updatedBook);
	
	//Book currentBook = getBook(id);
	//if (currentBook != null) {
		//currentBook.updateBook(updatedBook);
	//}
	//return books;

}

public List<Book> deleteBook(int id) {
	return PersistantBook.deleteBook(id);
	
	//books.removeIf(b -> b.getId() == id);
	//return books;
}


}
