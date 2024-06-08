package com.atguigu.Utils;

/**
 * ClassName: ResultCodeEnum
 * Package: com.atguigu.Utils
 * Description:用枚举封装Result返回类的code和message，不同的公司枚举里的状态码对应的信息可能不同
 *
 * @Author :Cooker38
 * @Create 2024/6/8 21:13
 * @Version 1.0
 */
public enum ResultCodeEnum {
    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed");
    private Integer code;
    private String message;
    ResultCodeEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }
    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }

}
