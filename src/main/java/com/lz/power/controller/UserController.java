package com.lz.power.controller;

import com.lz.power.VO.ResultVO;
import com.lz.power.VO.ResultVOUtil;
import com.lz.power.entity.User;
import com.lz.power.repository.UserRe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 白 on 2019/3/19.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRe userRe;


    @PostMapping("register")
    public ResultVO register(@Valid User user, BindingResult bindingResult) {

        System.out.println(user);

        if (bindingResult.hasErrors()||user.getCode() != 18) {
            return ResultVOUtil.error(500, "参数不正确");
        }

        return ResultVOUtil.success();
    }


    @PostMapping("login")
    public ResultVO login(@Valid User user,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(500, "参数不正确");
        }

        List<User> userList = userRe.findByPhoneAndPassword(user.getPhone(), user.getPassword());

        if (userList.isEmpty() || userList.size() <= 0) {
            return ResultVOUtil.error(501, "用户名或密码错误");
        }
        return ResultVOUtil.success();
    }


}
