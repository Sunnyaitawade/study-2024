package com.study.sb_transaction_managment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users",schema="spring-boot")
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Integer salary;

	public User(String name, Integer salary) {
		this.name = name;
		this.salary = salary;
	}

}
