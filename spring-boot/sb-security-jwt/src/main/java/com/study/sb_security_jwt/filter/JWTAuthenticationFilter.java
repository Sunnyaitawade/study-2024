package com.study.sb_security_jwt.filter;/**
 * @name JWTAuthenticationFilter
 * @author NSA Studios
 * @date 7/14/2024
 */

import com.study.sb_security_jwt.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author NSA Studios
 * @name JWTAuthenticationFilter
 * @date 7/14/2024
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {
          String authorization = request.getHeader("Authorization");
        log.info("Header :  {}", authorization);
          String token = null;
          String userEmail = "";

        if (authorization != null && authorization.startsWith("Bearer")) {
            //looking good
            token = authorization.substring(7);
            try {
                userEmail = jwtService.extractUsername(token);
            } catch (IllegalArgumentException e) {
                logger.info("Illegal Argument while fetching the username !!");
                e.printStackTrace();
                filterChain.doFilter(request,response);
            } catch (ExpiredJwtException e) {
                logger.info("Given jwt token is expired !!");
                e.printStackTrace();
                filterChain.doFilter(request,response);
            } catch (MalformedJwtException e) {
                logger.info("Some changed has done in token !! Invalid Token");
                e.printStackTrace();
                filterChain.doFilter(request,response);
            } catch (Exception e) {
                e.printStackTrace();
                filterChain.doFilter(request,response);
            }
        } else {
            logger.info("Invalid Header Value !! ");
            filterChain.doFilter(request,response);
        }
//        if (authorization == null || authorization.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }


        if(userEmail!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if(jwtService.isTokenValid(token,userDetails)) {
                UsernamePasswordAuthenticationToken authToken  = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }else {
                logger.info("Validation fails !!");
            }
        }

        filterChain.doFilter(request,response);
    }



}
