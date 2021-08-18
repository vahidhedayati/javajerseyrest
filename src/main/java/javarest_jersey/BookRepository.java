package javarest_jersey;

import java.util.List;

public class BookRepository {
	
//private List<Book> books;

public BookRepository() {
	if (MockPersistence.getBooks() ==null || MockPersistence.getBooks().size()==0) {
		System.out.println("Generating initial books");
		
		
		Author author1 = MockPersistence.getAuthorByName("Harper", "Lee");
		if (author1==null) {
			author1 = new Author(100, "Harper", "Lee");	
		}
				
		
		// books = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setName("To Kill a Mockingbird");
		book1.setId(100);
		book1.setIsbn("A1B2C3");
		book1.setStockTotal(10);
		book1.setAuthor(author1);
		
		// Test persisted author object 
		Author author2 = MockPersistence.getAuthorByName("Harper", "Lee");
		if (author2==null) {
			author2 = new Author(100, "Harper", "Lee");	
		} else {
			System.out.println("We found existing author on mocked Persistent object "+author2);
		}
		book1.setName("Go Set A Watchman");
		book1.setId(102);
		book1.setIsbn("A1B2C5");
		book1.setStockTotal(10);
		book1.setAuthor(author2);
		
		
		Book book2 = new Book(103, "Beloved", "A2B2C3", 20, new Author(100, "Toni", "Morrison"));
		
		// books.add(book1);
		// books.add(book2);
		
		MockPersistence.addBook(book1);
		MockPersistence.addBook(book2);
		System.out.println(" PB - "+MockPersistence.getBooks().size());
	
	}
		
}

public List<Book> getBooks() {
	return MockPersistence.getBooks();
	//return books;
}

public Book getBook(int id) {
	return MockPersistence.getBook(id);
	//return books.stream().filter(b -> b.getId() == id).findAny().orElse(null);
}

public void create(Book b) {
	MockPersistence.create(b);
	//books.add(b);
}

public List<Book> updateBook(int id, Book updatedBook) {
	
		
	return MockPersistence.updateBook(id, updatedBook);
	
	//Book currentBook = getBook(id);
	//if (currentBook != null) {
		//currentBook.updateBook(updatedBook);
	//}
	//return books;

}

public List<Book> deleteBook(int id) {
	return MockPersistence.deleteBook(id);
	
	//books.removeIf(b -> b.getId() == id);
	//return books;
}


}
