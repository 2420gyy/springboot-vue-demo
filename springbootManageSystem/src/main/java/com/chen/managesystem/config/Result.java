package com.chen.managesystem.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenchen
 * @date 2021-12-09 23:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public static Result success(){
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("success");
        return result;
    }
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode("0");
        result.setMsg("success");
        return result;
    }
    public static Result error(String code,String msg){
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}

