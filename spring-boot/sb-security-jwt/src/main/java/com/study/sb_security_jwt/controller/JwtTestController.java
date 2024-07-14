package com.study.sb_security_jwt.controller;/**
 * @name JwtTestController
 * @author NSA Studios
 * @date 7/14/2024
 */

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name JwtTestController
 * @author NSA Studios
 * @date 7/14/2024
 */
@RestController
@RequestMapping("/api/v1/demo-controller")
@Hidden
public class JwtTestController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

}
