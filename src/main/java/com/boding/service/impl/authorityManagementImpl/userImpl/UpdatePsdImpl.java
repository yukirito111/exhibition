package com.boding.service.impl.authorityManagementImpl.userImpl;

import com.boding.mapper.authorityManagement.UserMapper;
import com.boding.service.authorityManagement.user.UpdatePsd;
import com.boding.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class UpdatePsdImpl implements UpdatePsd {
    @Autowired
    UserMapper userMapper;
    @Override
    public String updatePsd(int id,String oldUserPsd,String newUserPsd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //验证口令是否正确
        boolean b = MyMD5Util.validPassword(oldUserPsd,userMapper.selectUserById(id).getUserPsd());

        String oldPsd = userMapper.selectUserById(id).getUserPsd();

        //加密
        String newPsd =MyMD5Util.getEncryptedPwd(newUserPsd);
        String tip = "";
         if (b && !oldUserPsd.equals(newUserPsd)) {
             userMapper.updateUserPsd(id,oldPsd,newPsd);
             tip = "修改成功";
         }else {
             tip = "修改失败";
         }
         return tip;
    }
}
