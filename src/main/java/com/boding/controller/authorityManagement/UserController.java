package com.boding.controller.authorityManagement;

import com.boding.pojo.authorityManagement.User;
import com.boding.pojo.authorityManagement.Userrolerelation;
import com.boding.service.authorityManagement.role.SelectRoleByName;
import com.boding.service.authorityManagement.user.*;
import com.boding.service.authorityManagement.userRole.DeleteUserRole;
import com.boding.service.authorityManagement.userRole.InsertUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import static com.boding.util.SystemDate.systemDate;

@Controller
@RequestMapping(value = "/user",method = {RequestMethod.POST,RequestMethod.GET})
public class UserController {
    @Autowired
    InsertUser insertUser;
    @Autowired
    SelectAllUser selectAllUser;
    @Autowired
    Login login;
    @Autowired
    UpdatePsd updatePsd;
    @Autowired
    InsertUserRole insertUserRole;
    @Autowired
    SelectUserByName selectUserByName;
    @Autowired
    SelectRoleByName selectRoleByName;
    @Autowired
    DeleteUserRole deleteUserRole;
    @Autowired
    DeleteUserById deleteUserById;
    @ResponseBody//添加用户
    @RequestMapping(value = "/insertUser",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView insertUser(@RequestBody User user,@RequestParam String roleName, HttpServletRequest request) throws ParseException{
        Date userDate = systemDate();//获取系统时间
        user.setUserDate(userDate);
        String tip = insertUser.insertUser(user);
        if (tip.equals("添加失败，用户名重复")){
            return null;
        }else {
            //放入请求
            request.setAttribute("userName",user.getUserName());
            request.setAttribute("roleName",roleName);
            //请求转发
            return new ModelAndView("forward:insertUserRole");
        }

    }
    @ResponseBody//授权用户角色
    @RequestMapping(value = "/insertUserRole",method = {RequestMethod.POST,RequestMethod.GET})
    public String insertUserRole(HttpServletRequest request){
        Userrolerelation userrolerelation = new Userrolerelation();
        int id = selectUserByName.selectUserByName((String) request.getAttribute("userName")).getUserId();
        int roleId = selectRoleByName.selectRoleByName((String) request.getAttribute("roleName")).getRoleId();
        userrolerelation.setUserId(id);
        userrolerelation.setRoleId(roleId);
        String tip = insertUserRole.inserUserRole(userrolerelation);
        return tip;
    }

    @ResponseBody//查询所有用户
    @RequestMapping(value = "/selectAllUser",method = {RequestMethod.POST,RequestMethod.GET})
    public List<User> selectAllUser(){
        List<User> list = selectAllUser.selectAllUser();
        return list;
    }
    @ResponseBody//登录
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    public String login(@RequestBody User user, HttpSession httpSession) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String tip ="";
        User user1 = login.login(user);
        if (user1 != null) {
            httpSession.setAttribute("user",user1);
           /* User user2 = (User) httpSession.getAttribute("user");
            System.out.println(user2.getUserName() + user2.getUserPsd());  //取出登录信息*/
            tip = "登陆成功";
            return tip;
        }else {
            tip = "登录失败";
            return tip;
        }
    }
    @ResponseBody//退出登录
    @RequestMapping("/out")
    public String out(HttpServletRequest request){
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements())//遍历执行remove操作
        {
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "已退出";
    }
    @ResponseBody//修改密码
    @RequestMapping(value = "/updatePsd",method = {RequestMethod.POST,RequestMethod.GET})
    public String updatePsd(@RequestParam int id,@RequestParam String oldPsd,@RequestParam String newPsd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String tip = updatePsd.updatePsd(id, oldPsd, newPsd);
        if (tip.equals("修改成功")){
            return tip;
        }else {
            return tip;
        }
    }
    @ResponseBody//删除用户
    @RequestMapping(value = "/deleteUserById",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView deleteUserById(@RequestParam int userId, HttpServletRequest request){
        //将用户ID存入request
        request.setAttribute("userId",userId);
        deleteUserById.deleteUserById(userId);
        //请求转发
        return new ModelAndView("forward:deleteUserRole");
    }
    @ResponseBody//取消角色授权
    @RequestMapping(value = "/deleteUserRole",method = {RequestMethod.POST,RequestMethod.GET})
    public String deleteUserRole(HttpServletRequest request){
        String tip = deleteUserRole.deleteUserRole((int)request.getAttribute("userId"));
        return tip;
    }
}
