package com.belal.media.Controller;

import com.belal.media.models.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String caption;
    private String image;
    private String video;
    private User user;

    private List<User> liked=new ArrayList<>();
    private LocalDateTime createdAt;

    public List<User> getLiked() {
        return liked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setLiked(List<User> liked) {
        this.liked = liked;
    }

    public Post(Integer id, String caption, String image, String video, User user, List<User> liked, LocalDateTime createdAt) {

        this.id = id;
        this.caption = caption;
        this.image = image;
        this.video = video;
        this.user = user;
        this.liked = liked;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt(LocalDateTime now) {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Post(){
        //TODO Auto-Generated constructor stub
    }
}
