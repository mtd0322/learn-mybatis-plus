package org.alan.utils;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * @program: learn-more
 * @ClassName: QRCodeUtil
 * @description: 属性配置
 * @author: AlanMa
 * @create: 2019-04-18 14:05
 */
public class PropertyConfig {

    /**
     * 是否是研发坏境
     */
    private static boolean isDevelop = true;

    private static String default_config = "config-product.properties";
    private static Properties mConfig;

    static {

        if (isDevelop) {
            default_config = "config-develop.properties";
        }
        mConfig = new Properties();
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(getPath() + default_config));
            mConfig.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return key != null ? mConfig.getProperty(key) != null ? mConfig.getProperty(key) : "" : "";
    }

    public static String getProperty(String key, String defaultValue) {

        String value = mConfig.getProperty(key);
        if (value == null)
            return defaultValue;

        return value;
    }

    public static boolean getBooleanProperty(String name, boolean defaultValue) {

        String value = PropertyConfig.getProperty(name);

        if (value == null)
            return defaultValue;

        return (new Boolean(value)).booleanValue();
    }

    public static int getIntProperty(String name) {
        return getIntProperty(name, 0);
    }

    public static int getIntProperty(String name, int defaultValue) {

        String value = PropertyConfig.getProperty(name);

        if (value == null)
            return defaultValue;

        return (new Integer(value)).intValue();
    }

    public static int getIntValueByKey(String key) {

        return Integer.parseInt(mConfig.getProperty(key));
    }

    public static String getStrValueByKey(String key) {

        String value = null;
        try {
            value = new String(mConfig.getProperty(key).getBytes("ISO8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return value;
    }

    public static String getPath() {

        String path = getClassFilePath(PropertyConfig.class);
        path = path.substring(0, path.lastIndexOf("classes") + 8);
        return path;
    }

    public static String getClassFilePath(Class<?> clazz) {

        try {
            return java.net.URLDecoder.decode(getClassFile(clazz)
                    .getAbsolutePath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

            return "";
        }
    }

    private static File getClassFile(Class<?> clazz) {

        URL path = clazz.getResource(clazz.getName().substring(
                clazz.getName().lastIndexOf(".") + 1)
                + ".class");
        if (path == null) {
            String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/" + name + ".class");
        }

        return new File(path.getFile());
    }
}
