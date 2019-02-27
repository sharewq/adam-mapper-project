package com.adam.mapper.Controller;

import com.adam.mapper.Mapper.SysUserDao;
import com.adam.mapper.Mapper.TUserDao;
import com.adam.mapper.Mapper.UserMapper;
import com.adam.mapper.bean.SysUser;
import com.adam.mapper.bean.TUser;
import com.adam.mapper.bean.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Think on 2017/12/14.
 */
@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TUserDao tUserDao;

    @Autowired
    SysUserDao sysUserDao;

    @RequestMapping(value = "/user")
    @ResponseBody
    public String user() {


        List<SysUser> list = sysUserDao.findUserAll();
        return list.toString();
    }


    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {

        return "hello world!";
    }

    public void testSelect() {
        User user = userMapper.findUserByName("7player");
        System.out.println(user.getName() + "-----" + user.getAge());
        List<User> list = userMapper.findUserInfo();
        System.out.println("list:" + list.get(0).getName() + list.get(0).getAge());
        for (int i = 1002; i < 1006; i++) {
            TUser tUser = new TUser();
            tUser.setUserId(i);
            tUser.setUserName("nihao" + i);
            tUser.setUserPassword("123456");
            tUser.setUserEmail("123456789");
            tUserDao.insertSelective(tUser);
        }
        PageHelper.startPage(1, 2);
        List<TUser> list2 = tUserDao.selectAll();
    }

}
