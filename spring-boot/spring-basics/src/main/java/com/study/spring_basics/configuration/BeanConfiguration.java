package com.study.spring_basics.configuration;/**
 * @name BeanConfiguration
 * @author NSA Studios
 * @date 8/24/2024
 */


import com.study.spring_basics.beans.PrototypeBean;
import com.study.spring_basics.beans.RequestBean;
import com.study.spring_basics.beans.SessionBean;
import com.study.spring_basics.beans.UserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * @name BeanConfiguration
 * @author NSA Studios
 * @date 8/24/2024
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public UserDetails getUserDetails() {
        return new UserDetails();
    }

    @Scope(value = "prototype")
    @Bean
    public PrototypeBean getProtoTypebean() {
        return new PrototypeBean();
    }

    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Bean
    public RequestBean getRequestBean() {
        return  new RequestBean();
    }

    @Scope(value= WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Bean
    public SessionBean getSessionBean() {
        return new SessionBean();
    }


}
