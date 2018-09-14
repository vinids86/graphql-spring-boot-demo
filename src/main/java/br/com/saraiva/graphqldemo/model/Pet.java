package br.com.saraiva.graphqldemo.model;

import java.util.List;

/**
 * Created by sara on set, 2018
 */
public class Pet {

	private String id;
	private String category;
	private String name;
	private List<String> photoUrls;
	private List<String> tags;
	private Status status;

	public Pet() {
	}

	public Pet(String category, String name, List<String> photoUrls, List<String> tags,
			Status status) {
		this(null, category, name, photoUrls, tags, status);
	}

	public Pet(String id, String category, String name, List<String> photoUrls,
			List<String> tags, Status status) {
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

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
