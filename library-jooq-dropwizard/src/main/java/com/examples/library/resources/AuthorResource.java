package com.examples.library.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.examples.library.dao.AuthorDAO;
import com.examples.library.db.jooq.tables.pojos.Author;

@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {
	private AuthorDAO dao;

	public AuthorResource(AuthorDAO dao) {
		this.dao = dao;
	}

	@GET
	@Path("/create")
	public Author createAuthor(@QueryParam("fname") String firstName,
			@QueryParam("lname") String lastName) {
		Author a = new Author(null, firstName, lastName);
		return dao.insertAuthor(a);
	}
	
	@GET
	@Path("/find")
	public Author findAuthor(@QueryParam("id") Long id){
		Author a = dao.fetchOneById(id);
		return a;
	}
	
	@GET
	@Path("/update")
	public Author updateAuthor(){
		//TO DO
		return null;
	}
	
	@GET
	@Path("/delete")
	public Author deleteAuthor(@QueryParam("id") Long id){
		Author a = dao.fetchOneById(id);
		dao.delete(a);
		return a;
	}
}
