package com.boding.service.impl.authorityManagementImpl.roleImpl;

import com.boding.mapper.authorityManagement.RoleMapper;
import com.boding.pojo.authorityManagement.Role;
import com.boding.service.authorityManagement.role.SelectAllRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectAllRoleImpl implements SelectAllRole {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> selectAllRole() {
        List<Role> list = roleMapper.selectAllRole();
        return list;
    }
}
