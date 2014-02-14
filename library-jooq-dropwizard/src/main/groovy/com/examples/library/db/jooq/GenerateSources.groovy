package com.examples.library.db.jooq

import javax.xml.bind.JAXB

import org.jooq.util.GenerationTool
import org.jooq.util.jaxb.Configuration as JooqConfiguration
import org.jooq.util.jaxb.Database
import org.jooq.util.jaxb.Generate
import org.jooq.util.jaxb.Generator
import org.jooq.util.jaxb.Jdbc
import org.jooq.util.jaxb.Target
/*
 * This class creates a config file for generating sources for jooq
 * @author Davis Nyabuti <davis@nyabuti.com>
 */

class GenerateSources {

	static main(args) {

		GenerateSources gs = new GenerateSources()
		String databaseName ="/library"
		String schema="library"
		String sourcesDir = "path-to\\library-jooq-dropwizard\\src\\main\\java"
		String package_ = "com.examples.library.db.jooq"
		String dbUrl = "jdbc:mysql://localhost:3306"
		String username = "root"
		String password = "53cretPa55"
		String driver = "com.mysql.jdbc.Driver"


		gs.generateJooq(dbUrl, schema, username, password, sourcesDir, package_, databaseName, driver)
	}


	public boolean generateJooq(String dbUrl, String schema, String username, String password, String sourcesDir, String package_, String databaseName, String driver){

		try {
			def jdbc = new Jdbc();
			def generator = new Generator();
			def configuration = new JooqConfiguration();

			//logger.info("Found driver {}", driver)
			def clazz = Thread.currentThread().getContextClassLoader().loadClass(driver)
			//logger.info ("Found clazz {}" , clazz)

			jdbc.setDriver(driver)
			jdbc.setUrl(dbUrl+databaseName)
			jdbc.setUser(username)
			jdbc.setPassword(password)

			Database database = new Database()
			database.setName("org.jooq.util.mysql.MySQLDatabase")
			database.setIncludes(".*")
			database.setExcludes("")
			database.setInputSchema(schema)

			Target target = new Target()
			target.setDirectory(sourcesDir)
			target.setPackageName(package_)

			Generate generate = new Generate();
			generate.setDaos(true)
			generate.setGeneratedAnnotation(false)

			generator.setDatabase(database)
			generator.setTarget(target)

			generator.setGenerate(generate)

			configuration.setGenerator(generator)
			configuration.setJdbc(jdbc);

			StringWriter writer = new StringWriter();
			JAXB.marshal(configuration, writer);

			println("Using this configuration:\n" + writer.toString());

			GenerationTool.main(configuration);
		}catch (Exception ex){
			return false;
		}
		return true
	}
}



