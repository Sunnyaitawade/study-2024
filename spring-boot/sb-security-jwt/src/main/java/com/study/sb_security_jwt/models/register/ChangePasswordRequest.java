package com.study.sb_security_jwt.models.register;/**
 * @name ChangePasswordRequest
 * @author NSA Studios
 * @date 7/14/2024
 */

/**
 * @name ChangePasswordRequest
 * @author NSA Studios
 * @date 7/14/2024
 */
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordRequest {

 private String currentPassword;
 private String newPassword;
 private String confirmationPassword;
}