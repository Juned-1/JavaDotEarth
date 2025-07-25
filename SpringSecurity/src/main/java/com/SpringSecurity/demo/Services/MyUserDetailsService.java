package com.SpringSecurity.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurity.demo.Model.UserPrincipal;
import com.SpringSecurity.demo.Model.Users;
import com.SpringSecurity.demo.Repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Users user = repo.findByUserName(username);

        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
    
}
