package javarest_jersey;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/authors")
public class AuthorResource {

	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ArrayList<Author> getAuthors() {
		return (ArrayList<Author>) MockPersistence.getAuthors();
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("author/{id}")
	public Author getAuthor(@PathParam("id") int id) {
		return MockPersistence.getAuthor(id);
	}
	
	/*
	 *  A book has author object bound 
		An author is created via a new book entry 
	@POST
	@Path("author")
	public Book createBook(Book b) {
		System.out.println(" Creating book: "+b.toString());
		repo.create(b);
		return b;
	}
	*/
	@PUT
	@Path("author/{id}")
	public ArrayList<Author> updateAuthor(@PathParam("id") int id, Author a) {
		return (ArrayList<Author>) MockPersistence.updateAuthor(id, a);
	}
	
	@DELETE
	@Path("author/{id}")
	public ArrayList<Author> deleteAuthor(@PathParam("id") int id) {
		return (ArrayList<Author>) MockPersistence.deleteAuthor(id);
	}
	
}
