package com.qfedu.edu.utils;

import com.alibaba.fastjson.JSON;
import com.qfedu.edu.result.R;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：当归
 * @description: HTTP响应的一个工具类
 * @Date：2024/6/6 下午10:35
 */
@Slf4j
public class HttpResponseUtils {
    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/6
    * @serviceLogic: 返回给客户端数据
    */
    public static void sendResponse(HttpServletResponse resp, R r){
        //将这个R对象弄成JSON格式
        String jsonString = JSON.toJSONString(r);
        //接下来将数据返回
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            writer.write(jsonString);
        } catch (IOException e) {
            log.error("获取响应流失败");
            throw new RuntimeException(e);
        }finally {
            if (writer != null) {
                writer.flush();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
