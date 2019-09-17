package com.boding.service.impl.authorityManagementImpl.roleRightImpl;

import com.boding.mapper.authorityManagement.RolerightrelationMapper;
import com.boding.service.authorityManagement.roleRight.InsertRoleRight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertRoleRightImpl implements InsertRoleRight {
    @Autowired
    RolerightrelationMapper rolerightrelationMapper;
    @Override
    public String insertRoleRight(int roleId, int rId, int rType) {
        rolerightrelationMapper.insertRoleRight(roleId, rId, rType);
        return "授权成功";
    }
}
