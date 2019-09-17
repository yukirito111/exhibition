package com.boding.controller.authorityManagement;


import com.boding.pojo.authorityManagement.Role;
import com.boding.service.authorityManagement.role.DeleteRoleById;
import com.boding.service.authorityManagement.role.InsertRole;
import com.boding.service.authorityManagement.role.SelectAllRole;
import com.boding.service.authorityManagement.role.UpdateRoleById;
import com.boding.service.authorityManagement.roleRight.InsertRoleRight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.boding.util.SystemDate.systemDate;

@Controller
@RequestMapping(value = "/role",method = {RequestMethod.POST,RequestMethod.GET})
public class RoleContorller {
    @Autowired
    InsertRole insertRole;
    @Autowired
    SelectAllRole selectAllRole;
    @Autowired
    DeleteRoleById deleteRoleById;
    @Autowired
    UpdateRoleById updateRoleById;
    @Autowired
    InsertRoleRight insertRoleRight;
    @ResponseBody//添加角色
    @RequestMapping(value = "/inserRole",method = {RequestMethod.POST,RequestMethod.GET})
    public String inserRole(@RequestParam String roleName,@RequestParam String description) throws ParseException {
        Date roleDate = systemDate();//获取系统时间
        String tip = insertRole.insertRole(roleName,roleDate,description);
        return tip;
    }
    @ResponseBody//查询所有角色
    @RequestMapping(value = "/selectAllRole",method = {RequestMethod.POST,RequestMethod.GET})
    public List<Role> showAllRole(){
        List<Role> list = selectAllRole.selectAllRole();
        return list;
    }
    @ResponseBody//通过ID删除角色
    @RequestMapping(value = "/deleteRoleById",method = {RequestMethod.POST,RequestMethod.GET})
    public String deleteRoleById(@RequestParam int id){
        String tip = deleteRoleById.deleteRoleById(id);
        return tip;
    }
    @ResponseBody//通过ID修改角色属性
    @RequestMapping(value = "/updateRoleById",method = {RequestMethod.POST,RequestMethod.GET})
    public String updateRoleById(@RequestParam int id,@RequestBody Role role){
        String tip = updateRoleById.updateRoleById(id, role);
        return tip;
    }
    @ResponseBody//给角色授权
    @RequestMapping(value = "/insertRoleRight",method = {RequestMethod.POST,RequestMethod.GET})
    public String insertRoleRight(@RequestParam int roleId,@RequestParam(value = "rId[]") int[] rId,@RequestParam int rType){
        String tip = "";
        for ( int id:rId
             ) {
            tip = insertRoleRight.insertRoleRight(roleId,id,rType);
        }
        return tip;
    }
}
