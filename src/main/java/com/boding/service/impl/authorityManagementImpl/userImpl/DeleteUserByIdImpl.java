package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.mapper.authorityManagement.UserMapper;
import com.boding.service.authorityManagement.user.DeleteUserById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserByIdImpl implements DeleteUserById {
    @Autowired
    UserMapper userMapper;
    @Override
    public void deleteUserById(int userId) {
        userMapper.deleteUserById(userId);
    }
}
