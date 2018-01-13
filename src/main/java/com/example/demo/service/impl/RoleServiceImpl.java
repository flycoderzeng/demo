package com.example.demo.service.impl;

import com.example.demo.mapper.RoleMapper;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Integer addRole(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public List<Role> findAllRole(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return roleMapper.selectAllRole(pageNum, pageSize);
    }

    @Override
    public Role loadRole(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
