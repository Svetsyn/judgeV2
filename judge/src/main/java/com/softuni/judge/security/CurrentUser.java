package com.softuni.judge.security;

import com.softuni.judge.model.entity.RoleNameEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private RoleNameEnum roleNameEnum;
    private String username;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleNameEnum getRoleNameEnum() {
        return roleNameEnum;
    }

    public void setRoleNameEnum(RoleNameEnum roleNameEnum) {
        this.roleNameEnum = roleNameEnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAnonymous() {
        return this.username == null;
    }

    public boolean isAdmin() {
        return this.roleNameEnum == RoleNameEnum.ADMIN;
    }

}
