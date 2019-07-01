package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Email;
import com.qf.entity.User;
import com.qf.service.IEmailService;
import com.qf.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @userzhangliang
 * @date2019/6/29 13:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUserService userService;

    @Reference
    private IEmailService emailService;

    @RequestMapping("/toregister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/tosucc")
    public String toSucc(){
        return "succ";
    }

    @RequestMapping("/find")
    public String toFind(){
        return "find";
    }

    @ResponseBody
    @RequestMapping("/register")
    public int register(@RequestParam String username,@RequestParam String password,@RequestParam String email, @RequestParam int code, HttpServletRequest request){

        User user= new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        int code1 = (int) request.getSession().getAttribute("code");
        System.out.println("session:"+code1);
        if(code==code1){
            return userService.register(user);
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("/login")
    public User login(@RequestParam String username,@RequestParam String password){

        return userService.getUser(username,password);
    }

    @ResponseBody
    @RequestMapping("/getcode")
    public void getCode(@RequestBody Email email,HttpServletRequest request){

        System.out.println(email.getEmail());
        int getcode = emailService.getcode(email);
        System.out.println(getcode);
        request.getSession().setAttribute("code",getcode);

    }

    @ResponseBody
    @RequestMapping("/tofind")
    public void find(@RequestParam String username){
        System.out.println(username);
        User user = userService.getUserByName(username);
        emailService.find(user);
    }

    @ResponseBody
    @RequestMapping("/update")
    public User updatePwd(@RequestParam String username,@RequestParam String password){
        User user = userService.getUserByName(username);
        user.setPassword(password);
        return null;
    }
}
