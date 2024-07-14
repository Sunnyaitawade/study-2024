package com.study.sb_security_jwt.models.register;/**
 * @name RegisterRequest
 * @author NSA Studios
 * @date 7/14/2024
 */

import com.study.sb_security_jwt.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @name RegisterRequest
 * @author NSA Studios
 * @date 7/14/2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}