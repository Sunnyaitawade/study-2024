package com.study.spring_basics.beans;/**
 * @name RequestBean
 * @author NSA Studios
 * @date 8/25/2024
 */

/**
 * @name RequestBean
 * @author NSA Studios
 * @date 8/25/2024
 */
public class RequestBean {

    private String beanType;

    public RequestBean() {
        this.beanType = "RequestScope-" +System.identityHashCode(this);
    }

    public String getBeanType() {
        return beanType;
    }
}
