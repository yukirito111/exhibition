package com.boding.service.impl.authorityManagementImpl.roleImpl;

import com.boding.mapper.authorityManagement.RoleMapper;
import com.boding.service.authorityManagement.role.InsertRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;


@Service
public class InsertRoleImpl implements InsertRole {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public String insertRole(String roleName, Date roleDate, String description) throws ParseException {
        String tip = "";
        //判断角色名是否重复
        if (roleMapper.selectCountByName(roleName) != 0){
            tip = "添加失败，角色名重复";
        }else {
            roleMapper.insertRole(roleName, roleDate, description);
            tip = "添加成功";
            return tip;
        }
        return tip;
    }
}
