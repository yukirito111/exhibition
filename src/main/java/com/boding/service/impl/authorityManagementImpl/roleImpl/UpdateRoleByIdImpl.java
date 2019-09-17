package com.boding.service.impl.authorityManagementImpl.roleImpl;

import com.boding.mapper.authorityManagement.RoleMapper;
import com.boding.pojo.authorityManagement.Role;
import com.boding.service.authorityManagement.role.UpdateRoleById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateRoleByIdImpl implements UpdateRoleById {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public String updateRoleById(int id, Role role) {
        //判断前端传的参数是否为null，如果为null，就赋值原来的数值，从而实现不修改的目的
        if (role.getRoleName() == null){
            role.setRoleName(roleMapper.selectRoleById(id).getRoleName());
            roleMapper.updateRoleById(id, role.getRoleName(), role.getDescription());
        }else if (role.getDescription() == null){
            role.setDescription(roleMapper.selectRoleById(id).getDescription());
            roleMapper.updateRoleById(id, role.getRoleName(), role.getDescription());
        }else {
            roleMapper.updateRoleById(id, role.getRoleName(), role.getDescription());
        }
        return "修改成功";
    }
}
