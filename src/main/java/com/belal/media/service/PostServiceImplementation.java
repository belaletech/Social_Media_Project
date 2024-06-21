package com.belal.media.service;

import com.belal.media.Controller.Post;
import com.belal.media.models.User;
import com.belal.media.repository.PostRepository;
import com.belal.media.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService{
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public Post createNewPost(Post post, Integer userId) throws Exception {
       User user=userService.findUserById(userId);


        Post newPost=new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.getCreatedAt(LocalDateTime.now());
        newPost.setVideo(post.getVideo());
        newPost.setUser(user);
        return newPost;
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {
        Post post=findPostById(postId);
        User user=userService.findUserById(userId);

        if(post.getUser().getId()!=user.getId())
        {
            throw new Exception("You can't delete another users post");
        }
        postRepository.delete(post);
        return "Post deleted successfully";
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {

        return postRepository.findPostByUserId(userId);
    }

    @Override
    public Post findPostById(Integer postId) throws Exception {
        Optional<Post>opt=postRepository.findById(postId);
        if(opt.isEmpty())
        {
            throw new Exception("Post not found with this id"+postId);
        }
        return opt.get();
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Integer postId, Integer userId) throws Exception {
        Post post=findPostById(postId);
        User user=userService.findUserById(userId);

        if(user.getSavePost().contains(post)){
            user.getSavePost().remove(post);
        }
        else {
            user.getSavePost().add(post);
        }
        userRepository.save(user);
        return post;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
        Post post=findPostById(postId);
        User user=userService.findUserById(userId);

        if(post.getLiked().contains(user))
        {
            post.getLiked().remove(user);
        }
        else {
            post.getLiked().add(user);
        }
        return postRepository.save(post);
    }
}
