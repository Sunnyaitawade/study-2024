package com.study.spring_basics.beans;/**
 * @name PrototypeBean
 * @author NSA Studios
 * @date 8/25/2024
 */

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * @name PrototypeBean
 * @author NSA Studios
 * @date 8/25/2024
 */
public class PrototypeBean {

    private String beanType;

    public PrototypeBean() {
        this.beanType = "protoypebean"+ System.identityHashCode(this);
    }

    public String getBeanType() {
        return beanType;
    }

       @PostConstruct
   public void postSample() {
       System.out.println("protoypebean   getting called at post ");

   }

    @PreDestroy
    public void closeuserDetails() {
        System.out.println("protoypebean before destory i am getting called");
    }
}
