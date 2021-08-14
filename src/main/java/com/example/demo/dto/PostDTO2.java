package com.example.demo.dto;

public class PostDTO2 {

	private Long id;

	private String title;

	private String review;

	private String name;

	public PostDTO2(Long id, String title, String review, String name) {
		this.id = id;
		this.title = title;
		this.review = review;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
