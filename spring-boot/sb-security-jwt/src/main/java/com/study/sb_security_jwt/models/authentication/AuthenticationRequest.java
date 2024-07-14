package com.study.sb_security_jwt.models.authentication;/**
 * @name AuthenticationRequest
 * @author NSA Studios
 * @date 7/14/2024
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @name AuthenticationRequest
 * @author NSA Studios
 * @date 7/14/2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private String email;
    private String password;
}
