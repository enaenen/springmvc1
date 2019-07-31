package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping (value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "id", required = false) String id,
                        @RequestParam (value="pw", required = false) String pwd,
                        @RequestParam (value="age", required = false) int age) {
        System.out.println("called login : " + id + " " + pwd);
        System.out.println(String.format("called login:%s, %s, %s",id,pwd, age));
        return "login";
    }
    @RequestMapping(value="/loginForm", method = RequestMethod.POST)
    public String loginForm(Member member){
        System.out.println("called loginForm");
        System.out.println(member.getId() + "/"+ member.getPwd());
        return "loginForm";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(@RequestParam(value="ids",required = false)String[] ids){
        for(String id : ids){
            System.out.println(id + ",");
        }
        System.out.println("called logout");
        return "logout";
    }
}
