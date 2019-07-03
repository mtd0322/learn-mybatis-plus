package org.alan.utils;

import java.security.MessageDigest;

/**
 * @program: learn-more
 * @ClassName: Md5Util
 * @description: MD5
 * @author: AlanMa
 * @create: 2019-04-18 14:05
 */
public class Md5Util {

    public static String MD5(String data) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }

        return sb.toString();
    }
}
