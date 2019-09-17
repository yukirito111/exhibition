package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.mapper.authorityManagement.UserMapper;
import com.boding.pojo.authorityManagement.User;
import com.boding.service.authorityManagement.user.SelectUserById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectUserByIdImpl implements SelectUserById {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectUserById(int id) {
        User user = userMapper.selectUserById(id);
        return user;
    }
}
