package javarest_jersey;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/mybooks")
public class BookResource {

	BookRepository repo = new BookRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ArrayList<Book> getBooks() {
		return (ArrayList<Book>) repo.getBooks();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("book/{id}")
	public Book getBook(@PathParam("id") int id) {
		return repo.getBook(id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("author/{firstName}")
	public Author getAuthorFromBook(@PathParam("firstName") String firstName) {
		System.out.println("Find author by firstName: "+firstName+"");
		return MockPersistence.getAuthorFromBook(firstName);
	}
	
	
	
	@POST
	@Path("book")
	public Book createBook(Book b) {
		System.out.println(" Creating book: "+b.toString());
		repo.create(b);
		return b;
	}
	
	@PUT
	@Path("book/{id}")
	public ArrayList<Book> updateBook(@PathParam("id") int id, Book b) {
		return (ArrayList<Book>) repo.updateBook(id, b);
	}
	
	@DELETE
	@Path("book/{id}")
	public ArrayList<Book> deleteBook(@PathParam("id") int id) {
		return (ArrayList<Book>) repo.deleteBook(id);
	}
	
}
