package com.boding.service.impl.authorityManagementImpl.roleImpl;

import com.boding.mapper.authorityManagement.RoleMapper;
import com.boding.pojo.authorityManagement.Role;
import com.boding.service.authorityManagement.role.SelectRoleByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectRoleByNameImpl implements SelectRoleByName {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Role selectRoleByName(String roleName) {
        Role role = roleMapper.selectRoleByName(roleName);
        return role;
    }
}
