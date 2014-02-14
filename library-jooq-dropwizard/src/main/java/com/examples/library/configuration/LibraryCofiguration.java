package com.examples.library.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

public class LibraryCofiguration extends Configuration {

	@Valid
	@NotNull
	@JsonProperty
	private DatabaseConfiguration database = new DatabaseConfiguration();

	public DatabaseConfiguration getDatabase() {
		return database;
	}

	public void setDatabase(DatabaseConfiguration database) {
		this.database = database;
	}
	
	public DSLContext getContext() throws SQLException{
		Connection conn = null;
		DSLContext context = null;
		conn = DriverManager.getConnection(database.getUrl(), database.getUser(), database.getPassword());
		context = DSL.using(conn, SQLDialect.MYSQL);
		return context;
	} 
	
	
}
