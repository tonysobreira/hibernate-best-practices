package com.example.demo.dto;

import com.example.demo.model.PostComment;

public class PostCommentDTO {

	private Long id;

	private String review;

	public PostCommentDTO() {
	}

	public PostCommentDTO(PostComment pc) {
		this.id = pc.getId();
		this.review = pc.getReview();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
