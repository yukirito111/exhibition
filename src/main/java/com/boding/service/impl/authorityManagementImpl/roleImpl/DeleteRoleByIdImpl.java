package com.boding.service.impl.authorityManagementImpl.roleImpl;

import com.boding.mapper.authorityManagement.RoleMapper;
import com.boding.service.authorityManagement.role.DeleteRoleById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteRoleByIdImpl implements DeleteRoleById {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public String deleteRoleById(int id) {
        roleMapper.deleteRoleById(id);
        return "删除成功";
    }
}
