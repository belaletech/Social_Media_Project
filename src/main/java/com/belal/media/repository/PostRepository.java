package com.belal.media.repository;

import com.belal.media.Controller.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("SELECT p FROM Post p WHERE p.userId = :userId")
    List<Post> findPostByUserId(Integer userId);
}
