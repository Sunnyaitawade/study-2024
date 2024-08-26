package com.study.spring_basics.controller;/**
 * @name SessionScopeController
 * @author NSA Studios
 * @date 8/25/2024
 */

import com.study.spring_basics.beans.SessionBean;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name SessionScopeController
 * @author NSA Studios
 * @date 8/25/2024
 */
@RestController
public class SessionScopeController {

    @Autowired
    SessionBean sessionBean;

    @GetMapping("/session-scope")
    public String getSessionScopedBean(HttpSession session) {
        System.out.println("Session ID "+session.getId()+" Scoped Bean ID: " + sessionBean.getBeanType());
        return "Session ID: " + session.getId() + ", Bean ID: " + sessionBean.getBeanType();
    }
}
