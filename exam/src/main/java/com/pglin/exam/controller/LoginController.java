package com.pglin.exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pglin.exam.entity.User;
import com.pglin.exam.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LinRenJie
 * @version 1.0.0
 * @ClassName LoginController.java
 * @Description TODO
 * @createTime 2022年07月23日
 */
@RestController
@RequestMapping("/adminUser")
@Slf4j
public class LoginController {
@Autowired
    UserMapper usermapper;
@PostMapping ("/register")
public String register (@RequestBody  User user){
    User username = usermapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
    if (username != null) {
        usermapper.insert(user);
    }
  return "ok";
}
    @PostMapping ("/login")
    public String login (@RequestBody User user){
    log.info("{}",user);
        User selectOne = usermapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        String msg = "";
        if (selectOne!=null){
            if (selectOne.getPassword().equals(user.getPassword())) {
            msg = "ok,登录者:"+user.getUsername();
            }else{
                msg = "密码错误";
            }
        }else {
            return "用户名不存在";
        }
        return msg;
    }
}
