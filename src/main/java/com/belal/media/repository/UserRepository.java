package com.belal.media.repository;

import com.belal.media.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Integer>{

    public User findByEmail(String email);
    @Query("select u from User u where u.firstName like %:query% or u.lastName like %:query% or U.email like %:query%")
    public List<User> searchUser(@Param("query") String query);
}
