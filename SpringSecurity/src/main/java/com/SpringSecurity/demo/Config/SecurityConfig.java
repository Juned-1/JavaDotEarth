package com.SpringSecurity.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityChain(HttpSecurity httpSecurity) throws Exception{
        // httpSecurity.csrf(customizer -> customizer.disable()); //disabling csrf
        // httpSecurity.authorizeHttpRequests(
        //     request -> request.anyRequest().authenticated()    
        // ); //doing authentication

        // //httpSecurity.formLogin(Customizer.withDefaults()); //enable default form

        // httpSecurity.httpBasic(Customizer.withDefaults()); //enable basic authentication for rest API access

        // httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        // Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
        //     @Override
        //     public void customize(CsrfConfigurer<HttpSecurity> customizer) {
        //         customizer.disable(); //disabling csrf
        //     }
        // };
        // httpSecurity.csrf(custCsrf);
        //return httpSecurity.build();

        //Build up pattern
        return httpSecurity.csrf(customizer -> customizer.disable()) //disabling csrf
        .authorizeHttpRequests(
            request -> request.anyRequest().authenticated()    
        ) //doing authentication

        //httpSecurity.formLogin(Customizer.withDefaults()); //enable default form
        .httpBasic(Customizer.withDefaults()) //enable basic authentication for rest API access
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }
}
