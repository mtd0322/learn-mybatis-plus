package org.alan.utils;

import org.springframework.util.Base64Utils;

/**
 * @program: learn-more
 * @ClassName: Base64Util
 * @description: B64工具类
 * @author: AlanMa
 * @create: 2019-04-18 11:16
 */
public class Base64Util {

    public static String encode(String beforeEncrypt) {

        return new String(Base64Utils.encode(beforeEncrypt.getBytes()));
    }

    public static String decode(String beforeDecrypt) {

        return new String(Base64Utils.decode(beforeDecrypt.getBytes()));
    }
}
