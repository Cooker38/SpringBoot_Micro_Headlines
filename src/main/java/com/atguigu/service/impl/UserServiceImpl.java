package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.Pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 25692
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-06-08 21:05:10
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




