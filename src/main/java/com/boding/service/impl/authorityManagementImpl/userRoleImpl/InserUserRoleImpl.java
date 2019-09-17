package com.boding.service.impl.authorityManagementImpl.userRoleImpl;

import com.boding.mapper.authorityManagement.UserrolerelationMapper;
import com.boding.pojo.authorityManagement.Userrolerelation;
import com.boding.service.authorityManagement.userRole.InsertUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InserUserRoleImpl implements InsertUserRole {
    @Autowired
    UserrolerelationMapper userrolerelationMapper;
    @Override
    public String inserUserRole(Userrolerelation userrolerelation) {
        userrolerelationMapper.insertUserRole(userrolerelation);
        return "添加成功";
    }
}
