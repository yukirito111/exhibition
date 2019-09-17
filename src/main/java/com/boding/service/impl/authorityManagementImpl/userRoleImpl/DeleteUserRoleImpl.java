package com.boding.service.impl.authorityManagementImpl.userRoleImpl;

import com.boding.mapper.authorityManagement.UserrolerelationMapper;
import com.boding.service.authorityManagement.userRole.DeleteUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserRoleImpl implements DeleteUserRole {
    @Autowired
    UserrolerelationMapper userrolerelationMapper;
    @Override
    public String deleteUserRole(int userId) {
        userrolerelationMapper.deleteUserRole(userId);
        return "删除成功";
    }
}
