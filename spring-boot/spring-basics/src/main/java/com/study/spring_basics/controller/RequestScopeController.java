package com.study.spring_basics.controller;/**
 * @name RequestScopeController
 * @author NSA Studios
 * @date 8/25/2024
 */

import com.study.spring_basics.beans.RequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name RequestScopeController
 * @author NSA Studios
 * @date 8/25/2024
 */
@RestController
public class RequestScopeController {

    @Autowired
    RequestBean requestBean;

    @GetMapping("/request-scope")
    public String getRequestScopedBean() {
        System.out.println("Request Scoped Bean ID: " + requestBean.getBeanType());
        return "Request Scoped Bean ID: " + requestBean.getBeanType();
    }
}
