package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.mapper.authorityManagement.UserMapper;
import com.boding.pojo.authorityManagement.User;
import com.boding.service.authorityManagement.user.SelectUserByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectUserByNameImpl implements SelectUserByName {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectUserByName(String userName) {
        User user = userMapper.selectUserByName(userName);
        return user;
    }
}
