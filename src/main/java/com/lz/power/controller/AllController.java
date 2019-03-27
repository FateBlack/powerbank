package com.lz.power.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 白 on 2019/3/19.
 */
@RestController
@RequestMapping("user")
public class AllController {
    @GetMapping("index")
    public ModelAndView index() {

        return new ModelAndView("index.html");
    }


    @GetMapping("userlogin")
    public ModelAndView userlogin() {
        return new ModelAndView("login.html");
    }

    @GetMapping("userReg")
    public ModelAndView userReg() {
        return new ModelAndView("register.html");
    }


}
