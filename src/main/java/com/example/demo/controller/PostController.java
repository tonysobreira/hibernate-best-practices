package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostDTO2;
import com.example.demo.dto.PostViewDTO;
import com.example.demo.model.Post;
import com.example.demo.model.PostComment;
import com.example.demo.model.PostView;
import com.example.demo.model.Tag;
import com.example.demo.repository.PostRepository;

@RestController
public class PostController {
	
	private PostRepository postRepository;
	
	public PostController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@PostMapping
	public PostDTO save(@RequestBody Post post) {
		return new PostDTO(postRepository.save(post));
	}
	
	@GetMapping(value = "{id}")
	public PostDTO getById(@PathVariable(value = "id") Long id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		Post post = null;
		
		if (optionalPost.isPresent()) {
			post = optionalPost.get();
			
			List<PostComment> comments = postRepository.findComments(id);
			post.setComments(comments);
			
			List<Tag> tags = postRepository.findTags(id);
			post.setTags(tags);
		}
		
		return new PostDTO(post);
	}
	
	@PutMapping(value = "/comment/{id}")
	public PostDTO update(@PathVariable(value = "id") Long id, @RequestBody PostComment comment) {
		Post post = postRepository.findPostCommentsById(id);
		comment.setReview(comment.getReview() + " - " + LocalDateTime.now().getSecond());
		comment.setPost(post);
		post.addComment(comment);
		post = postRepository.save(post);
		post.setTags(postRepository.findTags(post.getId()));
		return new PostDTO(post);
	}
	
	@PutMapping(value = "/tag/{id}")
	public PostDTO update(@PathVariable(value = "id") Long id, @RequestBody Tag tag) {
		Post post = postRepository.findPostTagsById(id);
		tag.setName(tag.getName() + " - " + LocalDateTime.now().getSecond());
		post.addTag(tag);
		post = postRepository.save(post);
		post.setComments(postRepository.findComments(post.getId()));
		return new PostDTO(post);
	}
	
	@DeleteMapping(value = "{id}")
	public PostDTO delete(@PathVariable(value = "id") Long id) {
		postRepository.deleteById(id);
		return new PostDTO();
	}
	
	@GetMapping(value = "/posts/{minId}/{maxId}")
	public List<PostDTO> getPosts(
			@PathVariable(value = "minId") Long minId,
			@PathVariable(value = "maxId") Long maxId) {
		//Post with PostComment
		List<Post> list1 = postRepository.getPostList(minId, maxId);
		//Post with Tag
		List<Post> list2 = postRepository.getPostList(list1);
		
		List<PostDTO> list = new ArrayList<PostDTO>();
		
		for (Post post1 : list1) {
			for (Post post2 : list2) {
				if (post1.getId().equals(post2.getId())) {
					post1.setTags(post2.getTags());
				}
			}
		}
		
		for (Post post1 : list1) {
			list.add(new PostDTO(post1));
		}
		
		return list;
	}
	
	@GetMapping(value = "/posts/{id}")
	public List<PostDTO2> getPostById(@PathVariable(value = "id") Long id) {
		return postRepository.getPostById(id);
	}
	
	@GetMapping(value = "/posts-view/{id}")
	public PostViewDTO getPostViewById(@PathVariable(value = "id") Long id) {
		PostViewDTO postViewDTO = new PostViewDTO();
		postViewDTO.setId(id);
		
		List<PostView> list = postRepository.findPostView(id);
		
		for (PostView postView : list) {
			
			if (postViewDTO.getPostTitle() == null) {
				postViewDTO.setPostTitle(postView.getTitle());
			}
			
			postViewDTO.getComments().add(new PostComment(postView.getReview()));
			postViewDTO.getTags().add(new Tag(postView.getName()));
		}
		
		return postViewDTO;
	}

}
