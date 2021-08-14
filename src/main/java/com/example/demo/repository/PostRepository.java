package com.example.demo.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.PostDTO2;
import com.example.demo.model.Post;
import com.example.demo.model.PostComment;
import com.example.demo.model.PostView;
import com.example.demo.model.Tag;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query(value = " SELECT DISTINCT p FROM Post p " 
			+ " LEFT JOIN FETCH p.comments "
			+ " WHERE p.id between :minId and :maxId ")
	@QueryHints(value = {@QueryHint(name = org.hibernate.annotations.QueryHints.PASS_DISTINCT_THROUGH, value = "false") })
	List<Post> getPostList(@Param(value = "minId") Long minId, @Param(value = "maxId") Long maxId);
	
	@Query(value = " SELECT DISTINCT p FROM Post p " 
			+ " LEFT JOIN FETCH p.tags "
			+ " WHERE p in :posts ")
	@QueryHints(value = {@QueryHint(name = org.hibernate.annotations.QueryHints.PASS_DISTINCT_THROUGH, value = "false") })
	List<Post> getPostList(@Param(value = "posts") List<Post> posts);
	
//	@Query(value = " SELECT p FROM Post p " 
//			+ " LEFT JOIN FETCH p.comments "
//			+ " LEFT JOIN FETCH p.tags "
//			+ " WHERE p.id BETWEEN :minId AND :maxId ")
//	List<Post> getPosts(@Param(value = "minId") Long minId, @Param(value = "maxId") Long maxId);
	
	@Query(value = " SELECT new com.example.demo.dto.PostDTO2(p.id, p.title, c.review, t.name) "
			+ " FROM Post p " 
			+ " LEFT JOIN p.comments c "
			+ " LEFT JOIN p.tags t "
			+ " WHERE p.id = :id ")
	List<PostDTO2> getPostById(@Param(value = "id") Long id);
	
	@Query(value = " SELECT p FROM Post p " 
			+ " LEFT JOIN FETCH p.comments c "
			+ " WHERE p.id = :id ")
	Post findPostCommentsById(@Param(value = "id") Long id);
	
	@Query(value = " SELECT p FROM Post p " 
			+ " LEFT JOIN FETCH p.tags t "
			+ " WHERE p.id = :id ")
	Post findPostTagsById(@Param(value = "id") Long id);
	
	// Find all PostComment by Post id
	@Query(value = " SELECT c FROM Post p " 
			+ " LEFT JOIN p.comments c "
			+ " WHERE p.id = :id ")
	List<PostComment> findComments(@Param(value = "id") Long id);
	
	// Find all Tag by Post id
	@Query(value = " SELECT t FROM Post p " 
			+ " LEFT JOIN p.tags t "
			+ " WHERE p.id = :id ")
	List<Tag> findTags(@Param(value = "id") Long id);
	
	
	@Query(value = " SELECT pv FROM PostView pv " 
			+ " WHERE pv.postId = :id ")
	List<PostView> findPostView(@Param(value = "id") Long id);
}
