package com.lz.power.controller;

import com.lz.power.VO.ResultVO;
import com.lz.power.VO.ResultVOUtil;
import com.lz.power.entity.User;
import com.lz.power.repository.UserRe;
import com.lz.power.services.UserService;
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

    @Autowired
    UserService userService;


    @PostMapping("register")
    public ResultVO register(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(500, "参数不正确");
        }

        List<User> userList = userRe.findByPhoneAndCodes(user.getPhone(), user.getCodes());

        if (userList == null || userList.isEmpty()) {
            return ResultVOUtil.error(500, "验证码错误");
        }

        User userB = userList.get(0);
        userB.setChecks(2);
        userB.setPassword(user.getPassword());
        userB.setUsername(user.getUsername());

        userRe.save(userB);

        return ResultVOUtil.success();
    }

    /**
     * 发送验证码
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("sendsms")
    public ResultVO sendSms(@Valid User user, BindingResult bindingResult) {

        System.out.println("用户"+user);

        if (bindingResult.hasErrors()) {
            System.out.println("参数不正确");
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultVOUtil.error(500, "参数不正确");

        }

        Boolean flag = userService.sendSms(user);

        if (flag == false) {
            return ResultVOUtil.error(500, "手机号不正确");
        }

        return ResultVOUtil.success();
    }




    @PostMapping("login")
    public ResultVO login(@Valid User user,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(500, "参数不正确");
        }

        List<User> userList = userRe.findByPhoneAndPasswordAndChecks(user.getPhone(), user.getPassword(), 2);

        if (userList.isEmpty() || userList.size() <= 0) {
            return ResultVOUtil.error(501, "用户名或密码错误");
        }
        return ResultVOUtil.success();
    }

}
