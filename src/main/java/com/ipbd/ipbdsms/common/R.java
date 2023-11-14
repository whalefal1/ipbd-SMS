package com.ipbd.ipbdsms.common;

import com.ipbd.ipbdsms.exception.ExceptionEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用响应结果类
 *定义后端响应的格式
 * @author 李朋逊
 * @date 2023/06/17
 */


@Data
public class R<T> {
    private Integer code; //1表示成功，0或其他数字表示失败
    private String msg;     //错误信息
    private T data;            //数据
    private Map map = new HashMap();  //动态数据

    private ExceptionEnum bodyNotMatch;

    /*
    功能实现成功响应实现方法
     */
    public static <T>  R<T> success(T object){
         R<T> r = new R<>();
         r.data = object;
         r.code = 1;
         return r;
    }

    /*
    功能实现失败响应方法
     */
    public static <T>  R<T> error(String msg){
        R<T> r = new R<>();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public static R error(ExceptionEnum bodyNotMatch, String message) {
        R r = new R<>();
        r.bodyNotMatch = bodyNotMatch;
        r.msg = message;
        return r;
    }
    public static R error(int code, String message) {
        R r = new R<>();
        r.code = code;
        r.msg = message;
        return r;
    }


    /*
    使用动态数据方法
     */
    public R<T> add(String key,Object value){
      this.map.put(key,value);
      return this;
    }


}
