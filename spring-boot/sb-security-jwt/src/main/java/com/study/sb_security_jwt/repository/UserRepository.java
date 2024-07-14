package com.study.sb_security_jwt.repository;/**
 * @name UserRepository
 * @author NSA Studios
 * @date 7/14/2024
 */

import com.study.sb_security_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @name UserRepository
 * @author NSA Studios
 * @date 7/14/2024
 */
public interface UserRepository extends JpaRepository <User,Integer>{


    Optional<User> findByEmail(String email);
}
