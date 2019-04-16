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

    @GetMapping("join")
    public ModelAndView join() {
        return new ModelAndView("join.html");
    }

    @GetMapping("produce")
    public ModelAndView produce() {
        return new ModelAndView("produce.html");
    }


    /**
     *  第二套 同等页面 ，经销商B
     * @return
     */

    @GetMapping("indexB")
    public ModelAndView indexB() {

        return new ModelAndView("indexB.html");
    }

    @GetMapping("userloginB")
    public ModelAndView userloginB() {
        return new ModelAndView("loginB.html");
    }

    @GetMapping("userRegB")
    public ModelAndView userRegB() {
        return new ModelAndView("registerB.html");
    }

    @GetMapping("joinB")
    public ModelAndView joinB() {
        return new ModelAndView("joinB.html");
    }

    @GetMapping("produceB")
    public ModelAndView produceB() {
        return new ModelAndView("produceB.html");
    }

}
