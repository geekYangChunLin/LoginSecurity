package com.qfedu.edu.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 当归
 * @title: R
 * @projectName CD-Java-JY-2401-Simple-Parent
 * @description: 统一结果集返回的这个R类
 * @date 2024/3/20  15:51
 */
@Data
public class R {

    //状态码
    private Integer code;
    //错误的提示信息
    private String message;
    //返回给客户端的数据
    private HashMap<String, Object> data = new HashMap<String, Object>();

    private R() {
    }

    /**
     * 请求成功
     *
     * @return
     */
    public static R ok() {
        R r = new R();
        r.setCode(ResponseCode.SUCCESS.getCode());
        r.setMessage(ResponseCode.SUCCESS.getMessage());
        return r;
    }

    /**
     * 失败不带状态码
     *
     * @return
     */
    public static R error() {
        R r = new R();
        r.setCode(ResponseCode.FAIL.getCode());
        r.setMessage(ResponseCode.FAIL.getMessage());
        return r;
    }

    public static R error(Integer code,String message) {
        R r = new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }


    /**
     * 失败带状态码
     *
     * @param responseCode
     * @return
     */
    public static R error(ResponseCode responseCode) {
        R r = new R();
        r.setCode(responseCode.getCode());
        r.setMessage(responseCode.getMessage());
        return r;
    }


    /**
     * 给返回结果集设置数据
     *
     * @param key
     * @param val
     * @return
     */
    public R data(String key, Object val) {
        this.data.put(key, val);
        return this;
    }

    /**
     * 重载
     *
     * @param maps
     * @return
     */
    public R data(Map<String, Object> maps) {
        //首先遍历这个数据
        Set<Map.Entry<String, Object>> entries = maps.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            this.data.put(key, value);
        }
        return this;
    }
}
