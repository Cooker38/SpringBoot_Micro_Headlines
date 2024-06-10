package com.atguigu.Config;

import com.atguigu.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: MyWebConfig
 * Package: com.atguigu.Config
 * Description:
 *
 * @Author :Cooker38
 * @Create 2024/6/10 13:45
 * @Version 1.0
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/headline/**");
    }
}
