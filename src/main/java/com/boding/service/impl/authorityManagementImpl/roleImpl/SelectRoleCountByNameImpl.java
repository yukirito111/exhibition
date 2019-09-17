package com.boding.service.impl.authorityManagementImpl.roleImpl;

import com.boding.mapper.authorityManagement.RoleMapper;
import com.boding.service.authorityManagement.role.SelectRoleCountByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectRoleCountByNameImpl implements SelectRoleCountByName {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Long selectRoleCountByName(String roleName) {
        Long count = roleMapper.selectCountByName(roleName);
        return count;
    }
}
