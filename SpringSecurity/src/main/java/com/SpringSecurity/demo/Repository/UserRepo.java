package com.SpringSecurity.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.demo.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
    //pass table model name and primary key type
    @Query("SELECT u FROM Users u WHERE u.username = :userName")
    Users findByUserName(@Param("userName") String username);
}
