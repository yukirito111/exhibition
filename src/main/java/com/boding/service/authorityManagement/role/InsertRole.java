package com.boding.service.authorityManagement.role;



import java.text.ParseException;
import java.util.Date;

public interface InsertRole {
    String insertRole(String roleName, Date roleDate, String description) throws ParseException;
}
