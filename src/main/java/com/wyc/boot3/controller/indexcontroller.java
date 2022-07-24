package com.wyc.boot3.controller;

import com.wyc.boot3.bean.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class indexcontroller {
    @GetMapping({"/","/login"})
    public String loginpage(){
        return "login";
    }
    @PostMapping("/login")
    public String dadwa(user user , HttpSession session, Model model){
        if (!StringUtils.isEmpty(user.getUsername())&&!StringUtils.isEmpty(user.getPassword()))
        { session.setAttribute("loginuser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","zhanghaomimacuowu");
            return "login";
        }

    }
    @GetMapping("/main.html")
    public String Stringdd(HttpSession session, Model model){
        Object loginuser = session.getAttribute("loginuser");
        if (loginuser!=null){
            return "main";
        }else {
            model.addAttribute("msg","weidenglu");
            return "login";
        }



    }
}
