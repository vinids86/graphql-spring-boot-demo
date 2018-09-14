package br.com.saraiva.graphqldemo.model;

import java.util.List;

/**
 * Created by sara on set, 2018
 */
public class Pet {

	private final String id;
	private final PetCategory category;
	private final String name;
	private final List<String> photoUrls;
	private final List<Tag> tags;
	private final Status status;

	public Pet(String id, PetCategory category, String name, List<String> photoUrls,
			List<Tag> tags, Status status) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public PetCategory getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public Status getStatus() {
		return status;
	}
}
