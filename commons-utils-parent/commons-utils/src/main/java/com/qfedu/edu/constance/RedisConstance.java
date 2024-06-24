package com.qfedu.edu.constance;

/**
 * @Author：当归
 * @description:  Redis的常量类
 * @Date：2024/6/22 下午8:17
 */
public class RedisConstance {

    //限流的前缀
    private static final String LIMIT_PREFIX = "limit:";

    //黑名单的前缀
    private static final String BLACK_PREFIX = "black";

    //记录请求过我们服务器的电脑的ip 的key
    private static final String REQ_IP_SET = "limit:req:ip";

    //分钟限流的数值
    private static final Integer LIMIT_MINUTE = 20;

    //小时限流的数值
    private static final Integer LIMIT_HOUR = 200;

    //天限流的数值
    private static final Integer LIMIT_DAY = 2000;

    //获取请求过服务器的机器的IP key
    public static String getReqIpSet(){
        return REQ_IP_SET;
    }

    //获取黑名单前缀
    public static String getBlackPrefix(){
        return BLACK_PREFIX;
    }
    //获取限流 day
    public static Integer getLimitDay(){
        return LIMIT_DAY;
    }
    //获取限流 hour
    public static Integer getLimitHour(){
        return LIMIT_HOUR;
    }
    //获取限流 minute
    public static Integer getLimitMinute(){
        return LIMIT_MINUTE;
    }
    //获取限流的前缀
    public static String getLimitPrefix(){
        return LIMIT_PREFIX;
    }

}
