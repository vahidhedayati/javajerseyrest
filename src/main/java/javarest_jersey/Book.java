package javarest_jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	
	private int id;
	private String name;
	private String isbn;
	private int stockTotal;
	
	public Book() {
		
	}
	
	public Book updateBook(Book updatedBook) {
		this.name = updatedBook.getName();
		this.isbn = updatedBook.getIsbn();
		this.stockTotal = updatedBook.getStockTotal();
		return this;
	}
	
	public Book(int id, String name, String isbn, int stockTotal) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.stockTotal = stockTotal;
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
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + ", stockTotal=" + stockTotal + "]";
	}
	

}
