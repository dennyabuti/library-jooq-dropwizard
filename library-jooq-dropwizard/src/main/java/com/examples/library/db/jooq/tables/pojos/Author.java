/**
 * This class is generated by jOOQ
 */
package com.examples.library.db.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Author implements java.io.Serializable {

	private static final long serialVersionUID = -1068778663;

	private java.lang.Long   id;
	private java.lang.String firstName;
	private java.lang.String lastName;

	public Author() {}

	public Author(
		java.lang.Long   id,
		java.lang.String firstName,
		java.lang.String lastName
	) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	public java.lang.String getLastName() {
		return this.lastName;
	}

	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}
}