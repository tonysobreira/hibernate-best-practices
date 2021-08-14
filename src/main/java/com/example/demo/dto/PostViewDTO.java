package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.PostComment;
import com.example.demo.model.Tag;

public class PostViewDTO {

	private Long id;

	private String postTitle;

	private List<PostComment> comments = new ArrayList<PostComment>();

	private List<Tag> tags = new ArrayList<Tag>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
