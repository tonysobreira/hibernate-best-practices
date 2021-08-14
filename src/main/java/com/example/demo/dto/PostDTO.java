package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Post;
import com.example.demo.model.PostComment;
import com.example.demo.model.Tag;

public class PostDTO {

	private Long id;

	private Post post;

	private List<PostComment> comments;

	private List<Tag> tags;
	
	public PostDTO() {
		
	}
	
	public PostDTO(Post post) {
		this.id = post.getId();
		this.post = post;
		this.comments = post.getComments();
		this.tags = post.getTags();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
