package com.softuni.judge.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleNameEnum roleNameEnum;

    public Role(RoleNameEnum name) {
        this.roleNameEnum=name;
    }


    @Enumerated(EnumType.STRING)
    public RoleNameEnum getRoleNameEnum() {
        return roleNameEnum;
    }

    public void setRoleNameEnum(RoleNameEnum roleNameEnum) {
        this.roleNameEnum = roleNameEnum;
    }
}
