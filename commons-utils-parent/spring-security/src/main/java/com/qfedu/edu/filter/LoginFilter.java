package com.qfedu.edu.filter;

import com.alibaba.fastjson2.JSON;
import com.qfedu.edu.pojo.User;
import com.qfedu.edu.result.R;
import com.qfedu.edu.result.ResponseCode;
import com.qfedu.edu.utils.HttpResponseUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.qfedu.edu.service.ITokenService;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;


import java.io.IOException;

/**
 * @Author：当归
 * @description: 处理登陆请求的过滤器
 * @Date：2024/6/6 下午9:30
 */
@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private ITokenService tokenService;
    private AuthenticationManager authenticationManager;

    public LoginFilter(ITokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        //只能使用Post请求
        this.setPostOnly(true);
        this.authenticationManager = authenticationManager;
        //设置登陆的地址
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/users/login", HttpMethod.POST.name())
        );
    }

    /*
     * @Author：当归 👨‍🦰❤️‍🩹️‍👧
     * @Date：2024/6/6
     * @serviceLogic: 重写UsernamePasswordAuthenticationFilter中attemptAuthentication方法
     *                使得其可以支持表单数据、JSON格式数据的传输
     */


    @Override
    public Authentication attemptAuthentication(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws AuthenticationException {
        //将前端传递的JSON格式的数据 取出来 封装成Java对象
        //如何获取JSON格式的数据（JSON ：post传输 存储在请求实体中）
        // 1、getParameter方式获取
        // 2、流的方式
        // 因为其传输的不是键值对 所有只能采用流接受
        ServletInputStream in = null;
        try {
            in = request.getInputStream();
            byte[] buf = new byte[1024];
            int read = in.read(buf);
            String val = new String(buf,0,read,"UTF-8");
            if(StringUtils.isEmpty(val)){
                //告诉其用户名和密码不能为空
                HttpResponseUtils.sendResponse(response, R.error(ResponseCode.USERNAME_PASSWORD_EMPTY_EXCEPTION));
                return null;
            }
            //接下来将这个值弄成Java对象
            User user = JSON.parseObject(val, User.class);
            UsernamePasswordAuthenticationToken authRequest = UsernamePasswordAuthenticationToken.unauthenticated(
                    user.getUserName()==null?"":user.getUserName().trim(),
                    user.getPassword()==null?"":user.getPassword().trim());
                    return authenticationManager.authenticate(authRequest);

        } catch (IOException e) {
            log.error("解析请求中对哒JSON格式出错：{}",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/6
    * @serviceLogic: 登陆成功之后的处理方案
    */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

    }

    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/6
    * @serviceLogic: 登陆失败后的处理方案 告诉其用户名或者密码错误就可以了
    */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        ResponseCode res = ResponseCode.USERNAME_PASSWORD_EMPTY_EXCEPTION;
        //接下来响应给客户端
        HttpResponseUtils.sendResponse(response,R.error(res));
    }
}
