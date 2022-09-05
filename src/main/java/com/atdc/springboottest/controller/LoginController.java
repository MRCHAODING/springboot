package com.atdc.springboottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")

    public String login(@RequestParam("username") String username, @RequestParam("password") String password
            , Model model, HttpSession httpSession) {
        if(!username.isEmpty()&&password.equals("1")){
            httpSession.setAttribute("loginuser",username);
            return "dashboard";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }

    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";

    }
}
