package com.qfedu.edu.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author：当归
 * @description: IP地址的工具类
 * @Date：2024/6/22 下午8:35
 */
public class IpUtils {
    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/22
    * @serviceLogic: 通过请求找到这个ip地址
    */
    public static String getIpAddress(HttpServletRequest request){
        //TODO 这里要考虑实践的部署方式
        return "127.0.0.1";
    }
}
