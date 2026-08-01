package com.gymRat.gymRatBackEnd.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {


    private final String SECRET_KEY =
            "gymRatSecretKeyGymRatSecretKeyGymRatSecretKey123456";


    private final SecretKey key =
            Keys.hmacShaKeyFor(
                    SECRET_KEY.getBytes()
            );



    public String generateToken(String username) {

        return Jwts.builder()

                .subject(username)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60 * 24
                        )
                )

                .signWith(key)

                .compact();
    }



    public String extractUsername(String token) {


        Claims claims =
                Jwts.parser()

                        .verifyWith(key)

                        .build()

                        .parseSignedClaims(token)

                        .getPayload();


        return claims.getSubject();
    }


}