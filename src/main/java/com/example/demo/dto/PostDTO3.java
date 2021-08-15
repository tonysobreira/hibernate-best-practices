package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Post;

public class PostDTO3 {

	private Long id;

	private String title;

	private List<PostCommentDTO> comments;

	private List<TagDTO> tags;

	public PostDTO3(Post post, List<PostCommentDTO> comments, List<TagDTO> tags) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.comments = comments;
		this.tags = tags;
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

	public List<PostCommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<PostCommentDTO> comments) {
		this.comments = comments;
	}

	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}

}
