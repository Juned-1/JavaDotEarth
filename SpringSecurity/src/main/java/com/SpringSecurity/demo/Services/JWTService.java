package com.SpringSecurity.demo.Services;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64.Decoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
    private String secret = "";

    public JWTService(){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secret = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String generateToken(String username){
        //We have to create map of claims to create JWT with key value pair
        Map<String, Object> claimsMap = new HashMap<>();


        
        return Jwts
                .builder()
                .claims()
                .add(claimsMap)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) //7 days
                .and()
                .signWith(getKey())
                .compact(); //compact generate token
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);    
    }
}
