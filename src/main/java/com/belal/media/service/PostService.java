package com.belal.media.service;

import com.belal.media.Controller.Post;

import java.util.List;

public interface PostService {

    Post createNewPost(Post post, Integer userId)throws Exception;

    String deletePost(Integer postId,Integer userId) throws Exception;

    List<Post> findPostByUserId(Integer userId);

    Post findPostById(Integer postId) throws Exception;

    List<Post>findAllPost();

    Post savePost(Integer postId,Integer userId) throws Exception;

    Post likePost(Integer postId,Integer userId) throws Exception;
}
