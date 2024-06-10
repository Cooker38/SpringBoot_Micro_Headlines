package com.atguigu;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.Utils.JwtHelper;
import com.atguigu.Utils.Result;
import com.atguigu.Utils.ResultCodeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: LoginInterceptor
 * Package: com.atguigu
 * Description:
 *
 * @Author :Cooker38
 * @Create 2024/6/10 13:46
 * @Version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        if(StringUtils.isEmpty(token)&&jwtHelper.isExpiration(token)) {
            Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(request);
            response.getWriter().print(json);
            return false;
        }else {
            return true;
        }
    }
}
