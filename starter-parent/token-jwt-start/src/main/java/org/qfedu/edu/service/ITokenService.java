package org.qfedu.edu.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.stereotype.Component;

/**
 * @Author：当归
 * @description: 对Token进行创建、解析、校验、刷新
 * @Date：2024/6/6 下午9:41
 */
@Component
public interface ITokenService {
    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/6
    * @serviceLogic: 创建Token
    */
    String createToken(Long userId,String username);

    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/6
    * @serviceLogic: 解析Token
    */
    Jws<Claims> parseToken(String token);

    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/6
    * @serviceLogic: 校验Token
    */
    boolean verify(String token);

    /*
    * @Author：当归 👨‍🦰❤️‍🩹️‍👧
    * @Date：2024/6/6
    * @serviceLogic: 刷新Token
    */
    String refreshToken(String token);
}
