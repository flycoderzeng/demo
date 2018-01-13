package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {
    int addRole(Role role);

    List<Role> findAllRole(int pageNum, int pageSize);

    Role loadRole(int id);
}
