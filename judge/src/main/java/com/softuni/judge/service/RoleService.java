package com.softuni.judge.service;

import com.softuni.judge.model.entity.Role;
import com.softuni.judge.model.entity.RoleNameEnum;

public interface RoleService {
    void initRole();

    Role findRole(RoleNameEnum roleNameEnum);

}
