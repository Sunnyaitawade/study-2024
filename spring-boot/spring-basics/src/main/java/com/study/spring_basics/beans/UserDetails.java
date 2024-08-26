package com.study.spring_basics.beans;/**
 * @name UserDetails
 * @author NSA Studios
 * @date 8/24/2024
 */

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @name UserDetails
 * @author NSA Studios
 * @date 8/24/2024
 */

public class UserDetails {
    private String username;


    public UserDetails() {
        this.username ="Bean-" + System.identityHashCode(this);
    }

//   @PostConstruct
//   public void postSample() {
//       System.out.println("Usedeatils   getting called at post ");
//
//   }
//
//    @PreDestroy
//    public void closeuserDetails() {
//        System.out.println("Usedeatils before destory i am getting called");
//    }
//    public UserDetails(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }


    public String getUsername() {
        return username;
    }
}
