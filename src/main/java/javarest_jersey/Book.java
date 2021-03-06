package javarest_jersey;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	
	private int id;
	private String name;
	private String isbn;
	private int stockTotal;
	Author author;
	
	List<Author> authors;
	
	public Book() {
		
	}
	
	public Book updateBook(Book updatedBook) {
		this.name = updatedBook.getName();
		this.isbn = updatedBook.getIsbn();
		this.stockTotal = updatedBook.getStockTotal();
		this.setAuthor(updatedBook.getAuthor());
		return this;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getStockTotal() {
		return stockTotal;
	}
	public void setStockTotal(int stockTotal) {
		this.stockTotal = stockTotal;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
		addToAuthors(author);
	}

	public void addToAuthors(Author author) {
		if (this.authors == null ||
				this.authors != null && !this.authors.contains(author)) {
			if (this.authors == null ) {
				this.authors = new ArrayList<Author>();
			}
			this.authors.add(author);
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + ", stockTotal=" + stockTotal + ", author="
				+ author + ", authors=" + authors + "]";
	}

	public Book(int id, String name, String isbn, int stockTotal, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.stockTotal = stockTotal;
		this.author = author;
	}

}
