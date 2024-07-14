package com.study.sb_security_jwt.repository;/**
 * @name TokenRepository
 * @author NSA Studios
 * @date 7/14/2024
 */

/**
 * @name TokenRepository
 * @author NSA Studios
 * @date 7/14/2024
 */
import java.util.List;
import java.util.Optional;

import com.study.sb_security_jwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Integer id);

    Optional<Token> findByToken(String token);
}