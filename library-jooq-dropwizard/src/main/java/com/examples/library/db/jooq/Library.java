/**
 * This class is generated by jOOQ
 */
package com.examples.library.db.jooq;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Library extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -675672490;

	/**
	 * The singleton instance of <code>library</code>
	 */
	public static final Library LIBRARY = new Library();

	/**
	 * No further instances allowed
	 */
	private Library() {
		super("library");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			com.examples.library.db.jooq.tables.Author.AUTHOR);
	}
}
