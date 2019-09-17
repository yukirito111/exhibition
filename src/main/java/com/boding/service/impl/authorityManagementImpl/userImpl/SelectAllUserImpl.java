package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.mapper.authorityManagement.UserMapper;
import com.boding.pojo.authorityManagement.User;
import com.boding.service.authorityManagement.user.SelectAllUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectAllUserImpl implements SelectAllUser {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectAllUser() {
        List<User> list = userMapper.selectAllUser();
        return list;
    }
}
