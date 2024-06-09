package com.atguigu.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.Utils.JwtHelper;
import com.atguigu.Utils.MD5Util;
import com.atguigu.Utils.Result;
import com.atguigu.Utils.ResultCodeEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.Pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author 25692
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-06-08 21:05:10
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired JwtHelper jwtHelper;

    @Override
    public Result Login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User loginuser=userMapper.selectOne(lambdaQueryWrapper);
        if(loginuser == null){
            return Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }
        if(!(StringUtils.isEmpty(loginuser.getUserPwd()) )&&
                (loginuser.getUserPwd().equals(MD5Util.encrypt(user.getUserPwd())))){
            String token = jwtHelper.createToken(Long.valueOf(loginuser.getUid()));
            Map map=new HashMap();
            map.put("token",token);
            return Result.ok(map);
        }


        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        if(jwtHelper.isExpiration(token)){
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        Long userId=jwtHelper.getUserId(token);
        if(userId!=null){
            User user=userMapper.selectById(userId);
            Map map=new HashMap();
            user.setUserPwd(null);
            map.put("user",user);
            return Result.ok(map);
        }
        return Result.build(null,ResultCodeEnum.NOTLOGIN);
    }

    @Override
    public Result checkUserName(String UserName) {
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getUsername,UserName);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if(user==null){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        return Result.ok(null);
    }

    @Override
    public Result regist(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        Long count=userMapper.selectCount(lambdaQueryWrapper);
        if(count>0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        userMapper.insert(user);
        return  Result.ok(null);
    }
}
//为什么有些泛型不用实现，比如说返回result，没有指定泛型



