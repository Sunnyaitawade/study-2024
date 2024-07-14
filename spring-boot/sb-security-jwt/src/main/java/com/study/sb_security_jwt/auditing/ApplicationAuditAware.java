package com.study.sb_security_jwt.auditing;/**
 * @name ApplicationAuditAware
 * @author NSA Studios
 * @date 7/14/2024
 */

/**
 * @name ApplicationAuditAware
 * @author NSA Studios
 * @date 7/14/2024
 */

import com.study.sb_security_jwt.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<Integer> {
 @Override
 public Optional<Integer> getCurrentAuditor() {
  Authentication authentication =
          SecurityContextHolder
                  .getContext()
                  .getAuthentication();
  if (authentication == null ||
          !authentication.isAuthenticated() ||
          authentication instanceof AnonymousAuthenticationToken
  ) {
   return Optional.empty();
  }

  User userPrincipal = (User) authentication.getPrincipal();
  return Optional.ofNullable(userPrincipal.getId());
 }
}