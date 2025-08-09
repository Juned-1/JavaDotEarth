package com.ProjectOAuth.outhTest.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) //authenticating all request
        .oauth2Login(Customizer.withDefaults()); //allowing Oauth2 login
        return httpSecurity.build();
    }
}
