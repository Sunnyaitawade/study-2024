package com.study.sb_security_jwt.service;/**
 * @name JwtService
 * @author NSA Studios
 * @date 7/14/2024
 */

import io.jsonwebtoken.Claims;

import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * @name JwtService
 * @author NSA Studios
 * @date 7/14/2024
 */
public interface JwtService {
      String extractUsername(String jwt);
      <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
      String generateToken(UserDetails userDetails);
      String generateToken(
              Map<String, Object> extraClaims,
              UserDetails userDetails
      );
        boolean isTokenValid(String token, UserDetails userDetails);

        String generateRefreshToken(
              UserDetails userDetails
      );

}
