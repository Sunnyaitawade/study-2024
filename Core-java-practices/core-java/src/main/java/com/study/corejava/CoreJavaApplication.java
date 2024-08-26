package com.study.corejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CoreJavaApplication {

	public static void main(String[] args) {
		ApplicationContext primaryContext = SpringApplication.run(CoreJavaApplication.class, args);
		//context.close();
	}

}
