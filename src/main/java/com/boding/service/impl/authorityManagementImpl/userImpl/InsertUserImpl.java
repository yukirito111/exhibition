package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.mapper.authorityManagement.UserMapper;
import com.boding.pojo.authorityManagement.User;
import com.boding.service.authorityManagement.user.InsertUser;
import com.boding.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class InsertUserImpl implements InsertUser {
    @Autowired
    UserMapper userMapper;
    @Override
    public String insertUser(User user) {
        String tip = "";
        //判断用户名是否重复
       if (userMapper.selectCountByName(user.getUserName())!= 0){
           tip = "添加失败，用户名重复";
       }else {
           try {
               String psd = MyMD5Util.getEncryptedPwd(user.getUserPsd());
               tip = "添加成功";
               user.setUserPsd(psd);
               userMapper.insertUser(user);
               return tip;
           } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
               e.printStackTrace();
           }

       }
       return tip;
        }


}
