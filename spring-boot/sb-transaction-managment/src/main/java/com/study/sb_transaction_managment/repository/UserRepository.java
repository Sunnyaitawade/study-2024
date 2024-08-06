package com.study.sb_transaction_managment.repository;


import com.study.sb_transaction_managment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
