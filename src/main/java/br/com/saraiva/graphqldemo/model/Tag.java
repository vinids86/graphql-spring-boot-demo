package br.com.saraiva.graphqldemo.model;

/**
 * Created by sara on set, 2018
 */
public class Tag {

	private final String id;
	private final String name;

	public Tag(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
