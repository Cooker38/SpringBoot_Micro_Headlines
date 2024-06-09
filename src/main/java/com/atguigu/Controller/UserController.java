package com.atguigu.Controller;

import com.atguigu.Pojo.User;
import com.atguigu.Utils.Result;
import com.atguigu.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: UserController
 * Package: com.atguigu.Controller
 * Description:
 *
 * @Author :Cooker38
 * @Create 2024/6/9 17:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public Result Login(@RequestBody User user){
        Result result=userService.Login(user);
        return result;
    }
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        Result result=userService.getUserInfo(token);
        return result;
    }
    @PostMapping("/checkUserName")
    public Result checkUserName( String username){
        Result result= userService.checkUserName(username);

        return result;
    }
    @PostMapping("/regist")
    public Result regist(@RequestBody User user){
        Result result=userService.regist(user);
        return result;
    }



}
