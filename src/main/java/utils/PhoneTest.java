package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 白 on 2019/3/27.
 *
 * 测试手机号
 */
public class PhoneTest {

    private static boolean isPhone(String phone) {
        String regExp = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9])|(16[0-9]))\\d{8}$";;

        //港台版本
//        String regExp = "^(5|6|8|9)\\d{7}$";

        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);

        return m.matches();
    }

    public static void main(String[] args) {
        Boolean f = isPhone("18218510035");
        System.out.println(f);
    }
}
