package com.lz.power.services.impl;

import com.aliyuncs.exceptions.ClientException;
import com.lz.power.entity.User;
import com.lz.power.repository.UserRe;
import com.lz.power.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.smsUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by 白 on 2019/3/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRe userRe;

    @Override
    public boolean sendSms(User user) {
        Boolean flag = isPhone(user.getPhone());

        if (flag == false) {
            System.out.println("格式不正确");
            return false;
        }

        flag = false;

        int a = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
        String code = String.valueOf(a);

        user.setCodes(a);
        user.setChecks(1);

        try {
            flag = smsUtil.send(user.getPhone(),code); // 发送短信
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (flag == false) {
            return false;
        }

        userRe.save(user);
        return true;
    }

    // 验证是否为 大陆手机号
    private boolean isPhone(String phone) {
        String regExp = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9])|(16[0-9]))\\d{8}$";

        //港台版本
//        String regExp = "^(5|6|8|9)\\d{7}$";

        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);

        return m.matches();
    }


}
