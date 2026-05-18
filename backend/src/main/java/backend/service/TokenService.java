package backend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class TokenService {

    private final String SECRET =
            "mysupersecretkeymysupersecretkey";

    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .signWith(getSigningKey(),
                        SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getSigningKey() {
        return Keys.hmacShaKeyFor(
                SECRET.getBytes()
        );
    }
}