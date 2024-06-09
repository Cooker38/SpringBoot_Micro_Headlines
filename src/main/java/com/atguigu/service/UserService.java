package com.atguigu.service;

import com.atguigu.Pojo.User;
import com.atguigu.Utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25692
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-06-08 21:05:10
*/
public interface UserService extends IService<User> {

    Result Login(User user);

    Result getUserInfo(String token);

    Result checkUserName(String UserName);

    Result regist(User user);
}
