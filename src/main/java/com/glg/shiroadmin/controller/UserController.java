package com.glg.shiroadmin.controller;

import com.glg.shiroadmin.entity.User;
import com.glg.shiroadmin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
   @Autowired
   UserService userService;
    /**
     * 登录方法
     */
    @GetMapping("/login")
    @ResponseBody
    public String login(String username , String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);  //进入到realm里边认证方法
            User user = (User) subject.getPrincipal();
            subject.getSession().setAttribute("user",user);
            return "登录成功";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("error","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("error","密码错误");
            return "没有此人";
        }
    }
    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
    @GetMapping("/unauth")
    @ResponseBody
    public String unauth(){
        return "未授权 禁止访问";
    }

    //开放接口 无需登录
    @GetMapping("/public")
    @ResponseBody
    public String open(){
        return "这是open权限接口";
    }
    //只需登录
    @GetMapping("/userList")
    @ResponseBody
    public List<User> getUserList(){
        List<User> userList = userService.getAllUser();
        return userList;
    }
    //系统管理员才能访问
    @GetMapping("/systemadmin")
    @ResponseBody
//    @RequiresRoles("系统管理员")
    public String systemadmin(){
        return "这是systemadmin权限接口，系统管理员才能访问";
    }
    //功能模块管理员才能访问
    @GetMapping("/menusystem")
    @ResponseBody
//    @RequiresRoles("功能管理员")
    public String menusystem(){
        return "这是menusystem权限接口，功能模块管理员才能访问";
    }
    //用户管理员才能访问
    @GetMapping("/usersystem")
    @ResponseBody
//    @RequiresRoles("用户管理员")
    public String usersystem(){
        return "这是usersystem权限接口，用户管理员才能访问";
    }

}
