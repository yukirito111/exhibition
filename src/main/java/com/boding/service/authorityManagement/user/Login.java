package com.boding.service.authorityManagement.user;

import com.boding.pojo.authorityManagement.User;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface Login {
    public User login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;

}
