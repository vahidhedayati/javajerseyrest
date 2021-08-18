package javarest_jersey;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Author {
	
	private int id;
	private String firstName;
	private String lastName;
	
	
	public Author() {
		
	}
	
	public Author updateAuthor(Author updatedAuthor) {
		this.firstName = updatedAuthor.getFirstName();
		this.lastName = updatedAuthor.getLastName();
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Book> getBooks() {
		return (ArrayList<Book>) MockPersistence.getBooksByAuthor(this);
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Author(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

}
