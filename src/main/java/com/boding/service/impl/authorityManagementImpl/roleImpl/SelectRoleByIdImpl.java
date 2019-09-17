package com.boding.service.impl.authorityManagementImpl.roleImpl;

import com.boding.mapper.authorityManagement.RoleMapper;
import com.boding.pojo.authorityManagement.Role;
import com.boding.service.authorityManagement.role.SeleteRoleById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectRoleByIdImpl implements SeleteRoleById {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Role selectRoleById(int id) {
        Role role = roleMapper.selectRoleById(id);
        return role;
    }
}
