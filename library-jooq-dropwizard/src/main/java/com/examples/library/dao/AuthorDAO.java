package com.examples.library.dao;

import static com.examples.library.db.jooq.tables.Author.AUTHOR;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.examples.library.db.jooq.tables.daos.AuthorDao;
import com.examples.library.db.jooq.tables.pojos.Author;
import com.examples.library.db.jooq.tables.records.AuthorRecord;

/*
 * This class extends the auto generated dao class to implement 
 */
public class AuthorDAO extends AuthorDao {

	public AuthorDAO(Configuration config) {
		super(config);
	}
	
/*
 * In the database the id column needs be set to BIGINT and autoincrement
 */
	

	public Author insertAuthor(Author author) {
		DSLContext create = DSL.using(super.configuration().connectionProvider().acquire(),
				SQLDialect.MYSQL);
		AuthorRecord r = create.newRecord(AUTHOR);
		r.setFirstName(author.getFirstName());
		r.setLastName(author.getLastName());
		r.store();
		author.setId(r.getId());
		System.out.println("Your id is" + r.getId());
		return author;
	}

}
