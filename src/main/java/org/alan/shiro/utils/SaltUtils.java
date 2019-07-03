package org.alan.shiro.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * @program: learn-more
 * @ClassName: SaltUtils
 * @description: 盐加密
 * @author: AlanMa
 * @create: 2019-04-25 12:47
 */
public class SaltUtils {

    /**
     * 生成32的随机盐值
     */
    public static String createSalt(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 加盐加密
     * @param srcPassword    原始密码
     * @param saltValue 盐值
     */
    public static String MD5Salt(Object srcPassword, String saltValue){
        return new SimpleHash("MD5", srcPassword, saltValue, 1024).toString();
    }
}