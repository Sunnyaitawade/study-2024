package com.study.sb_security_jwt.filter;/**
 * @name JWTAuthenticationFilter
 * @author NSA Studios
 * @date 7/14/2024
 */

import com.poc.utility.exception.models.CustomException;
import com.poc.utility.exception.models.ErrorModel;
import com.poc.utility.exception.models.ErrorResponseModel;
import com.poc.utility.exception.models.ErrorType;
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
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
                throw new CustomException(buildSingleError(HttpStatus.BAD_REQUEST.value() + "", "Invalid JWT token", ErrorType.CLIENT.toString()));

            } catch (ExpiredJwtException e) {
                logger.info("Given jwt token is expired !!");
                throw new CustomException(buildSingleError(HttpStatus.BAD_REQUEST.value() + "", "Given jwt token is expired !!", ErrorType.CLIENT.toString()));


            } catch (MalformedJwtException e) {
                logger.info("Some changed has done in token !! Invalid Token");
               // throw new HttpMessageNotReadableException("Some changed has done in token !! Invalid Token");
                handleException(response,"Some changed has done in token !! Invalid Token");

            } catch (Exception e) {
                throw e;
            }
        } else {
            logger.info("Invalid Header Value !! ");
            throw new CustomException(buildSingleError(HttpStatus.BAD_REQUEST.value() + "", "Invalid Header Value !! ", ErrorType.CLIENT.toString()));

        }
//        if (authorization == null || authorization.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }


        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if (jwtService.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                logger.info("Validation fails !!");
                throw new CustomException(buildSingleError(HttpStatus.BAD_REQUEST.value() + "", "Validation fails !!", ErrorType.CLIENT.toString()));

            }
        }

        filterChain.doFilter(request, response);
    }

    private ErrorResponseModel buildSingleError(String code, String detail, String source) {

        ErrorModel errorModel = ErrorModel
                .builder()
                .code(code)
                .source(source)
                .detail(detail)
                .timestamp(LocalDate.now())
                .build();

        List<ErrorModel> errorModels = new ArrayList<ErrorModel>();
        errorModels.add(errorModel);
        ErrorResponseModel errorResponseModel = new ErrorResponseModel();
        errorResponseModel.setErrorModels(errorModels);
        errorResponseModel.setType(ErrorType.CLIENT.toString());
        return errorResponseModel;
    }

    private void handleException(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getOutputStream().println("{ \"error\": \"" + message + "\" }");
    }

}
