package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.PostDTO;
import com.example.demo.model.Post;
import com.example.demo.model.PostComment;
import com.example.demo.model.Tag;
import com.example.demo.repository.PostRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Post> list = new ArrayList<Post>();
		Post p = null;
		PostComment pc = null;
		Tag t = null;

//		for (int i = 1; i <= 50; i++) {
//			p = new Post();
//			p.setTitle("Title" + i);
//
//			if (i <= 20) {
//				pc = new PostComment();
//				pc.setReview("Review" + i);
//				pc.setPost(p);
//				p.addComment(pc);
//			}
//
//			if (i <= 10) {
//				t = new Tag();
//				t.setName("Name" + i);
//				p.addTag(t);
//			}
//
//			list.add(p);
//		}
//
//		postRepository.saveAll(list);

//		List<Post> list2 = postRepository.getPostList(1L, 50L);
//
//		List<Post> list3 = postRepository.getPostList(list2);
//
//		for (Post post : list2) {
//			for (PostComment postComment : post.getComments()) {
//				System.out.println(post);
//				System.out.println(postComment);
//			}
//		}
//
//		for (Post post : list3) {
//			for (Tag tag : post.getTags()) {
//				System.out.println(post);
//				System.out.println(tag);
//			}
//		}
		
//		List<Post> list3 = postRepository.getPosts(1L, 50L);
//		System.out.println(list3.size());
		
		
//		PostDTO postDTO = postRepository.getPostById(1L);
//		System.out.println(postDTO);
		
		

	}

}
