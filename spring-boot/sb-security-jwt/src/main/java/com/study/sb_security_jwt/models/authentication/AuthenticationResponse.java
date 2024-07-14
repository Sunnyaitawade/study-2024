package com.study.sb_security_jwt.models.authentication;/**
 * @name AuthenticationResponse
 * @author NSA Studios
 * @date 7/14/2024
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @name AuthenticationResponse
 * @author NSA Studios
 * @date 7/14/2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
}