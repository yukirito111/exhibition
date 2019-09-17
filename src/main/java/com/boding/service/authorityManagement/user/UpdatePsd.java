package com.boding.service.authorityManagement.user;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UpdatePsd {
    public String updatePsd(int id,String oldUserPsd,String neUserPsd) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
