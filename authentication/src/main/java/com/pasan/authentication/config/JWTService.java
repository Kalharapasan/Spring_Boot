package com.pasan.authentication.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    private  static final String  SECRET_KEY ="746c814d42ae58af938f787a6de0bbf55684ff97363bf96225ed70c2a0e999f1";



    public String extractUsername(String token) {

        return extractCliams(token, Claims::getSubject);
    }

    public <T>T extractCliams(String tokan, Function<Claims, T> claimsExtractor) {
        final  Claims claims = extractAllClaims(tokan);
        return claimsExtractor.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSingInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSingInKey()).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {

        final String userName =extractUsername(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);

    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractCliams(token, Claims::getExpiration);
    }

    private Key getSingInKey() {
        byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(KeyBytes) ;
    }
}
