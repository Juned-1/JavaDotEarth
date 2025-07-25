package com.SpringSecurity.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.SpringSecurity.demo.Model.Users;
import com.SpringSecurity.demo.Repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    public Users register(Users user){
        return userRepo.save(user);
    }
    public String verify(Users user) {
        //By defualt authentication provider will do verification
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        if(authentication.isAuthenticated()) return jwtService.generateToken(user.getUsername()); //return true or false

        return "failed";
    }
}
