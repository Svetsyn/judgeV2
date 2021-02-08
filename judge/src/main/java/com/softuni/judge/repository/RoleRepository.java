package com.softuni.judge.repository;

import com.softuni.judge.model.entity.Role;
import com.softuni.judge.model.entity.RoleNameEnum;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

   Optional<Role> findByRoleNameEnum(RoleNameEnum roleNameEnum);
}
