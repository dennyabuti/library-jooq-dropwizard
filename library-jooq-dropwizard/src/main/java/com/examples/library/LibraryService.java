package com.examples.library;

import com.examples.library.configuration.LibraryCofiguration;
import com.examples.library.dao.AuthorDAO;
import com.examples.library.resources.AuthorResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class LibraryService extends Service<LibraryCofiguration>{

	public static void main(String[] args) throws Exception {
		new LibraryService().run(args);

	}

	@Override
	public void initialize(Bootstrap<LibraryCofiguration> bootstrap) {
		bootstrap.setName("library");
		
	}

	@Override
	public void run(LibraryCofiguration configuration, Environment environment)
			throws Exception {
		final AuthorDAO authorDao = new AuthorDAO(configuration.getContext().configuration());
		environment.addResource(new AuthorResource(authorDao));
		
	}
	


}
