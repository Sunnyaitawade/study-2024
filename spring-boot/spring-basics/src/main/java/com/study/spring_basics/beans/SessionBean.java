package com.study.spring_basics.beans;/**
 * @name SessionBean
 * @author NSA Studios
 * @date 8/25/2024
 */

/**
 * @name SessionBean
 * @author NSA Studios
 * @date 8/25/2024
 */
public class SessionBean {

 private String beanType;


 public SessionBean() {
  this.beanType = "SessionScope-"+System.identityHashCode(this);
 }

 public String getBeanType() {
  return beanType;
 }
}
