package com.belal.media.service;

import com.belal.media.Controller.Post;
import com.belal.media.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService{
    @Autowired
    PostRepository postRepository;

    @Override
    public Post createNewPost(Post post, Integer userId) throws Exception {
        Post newPost=new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
//        newPost.getCreatedAt(new Local)
        newPost.setVideo(post.getVideo());
        return null;
    }

    @Override
    public String deletePost(Integer postId, Integer userId) {
        return null;
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {
        return null;
    }

    @Override
    public Post findPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> findAllPost() {
        return null;
    }

    @Override
    public Post savePost(Integer postId, Integer userId) {
        return null;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) {
        return null;
    }
}
