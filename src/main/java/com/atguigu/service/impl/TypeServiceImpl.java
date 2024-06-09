package com.atguigu.service.impl;

import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.Pojo.Type;
import com.atguigu.service.TypeService;
import com.atguigu.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 25692
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-06-08 21:05:10
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{
    @Autowired
    private UserMapper userMapper;


}




