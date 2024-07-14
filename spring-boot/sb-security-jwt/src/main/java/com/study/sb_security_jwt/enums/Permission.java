package com.study.sb_security_jwt.enums;/**
 * @name Permission
 * @author NSA Studios
 * @date 7/14/2024
 */
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @name Permission
 * @author NSA Studios
 * @date 7/14/2024
 */
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete")

    ;

    @Getter
    private final String permission;
}
