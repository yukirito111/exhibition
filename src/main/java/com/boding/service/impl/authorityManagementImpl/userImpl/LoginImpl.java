package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.pojo.authorityManagement.User;
import com.boding.service.authorityManagement.user.Login;
import com.boding.service.authorityManagement.user.SelectAllUser;
import com.boding.service.authorityManagement.user.SelectUserByName;
import com.boding.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginImpl implements Login {
    @Autowired
    SelectAllUser selectAllUser;
    @Autowired
    SelectUserByName selectUserByName;

    public User login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        User user1 = null;
        //判断密码是否存在
        if (selectUserByName.selectUserByName(user.getUserName()).getUserPsd() != null) {
            //验证口令是否正确
            boolean b = MyMD5Util.validPassword(user.getUserPsd(), selectUserByName.selectUserByName(user.getUserName()).getUserPsd());
            if (b) {
                user1 = user;
                return user1;
            } else {
                return null;
            }

        }
        return user1;
    }

}
       
        //判断登录,如果用户名或密码查询不到，则登录失败
      /*  for (User olduser:list
             ) {
            if (user.getUserName().equals(olduser.getUserName())){
                if (user.getUserPsd().equals(selectUserByName.selectUserByName(user.getUserName()).getUserPsd()))//查询用户输入的用户名下的密码是否存在
                {
                    user1 = user;
                    return user1;
                }else {

                    user1 = null;
                }
            }else {

                    user1 = null;
            }
        }*/

