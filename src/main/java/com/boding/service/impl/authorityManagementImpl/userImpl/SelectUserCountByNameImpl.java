package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.mapper.authorityManagement.UserMapper;
import com.boding.service.authorityManagement.user.SelectUserCountByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectUserCountByNameImpl implements SelectUserCountByName {
    @Autowired
    UserMapper userMapper;
    @Override
    public long selectUserCountByName(String userName) {
        Long count = userMapper.selectCountByName(userName);
        return count;
    }
}
