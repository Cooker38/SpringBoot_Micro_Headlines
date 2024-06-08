package com.atguigu.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Result
 * Package: com.atguigu.Utils
 * Description:
 *
 * @Author :Cooker38
 * @Create 2024/6/8 21:00
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>{
    private Integer code;
    private String message;
    private T data;
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if(data != null){
            result.setData(data);
        }
        return result;
    }
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }
    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
