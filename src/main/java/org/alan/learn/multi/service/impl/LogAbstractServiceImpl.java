package org.alan.learn.multi.service.impl;

import com.alibaba.fastjson.JSON;
import org.alan.learn.multi.service.LogAbstractService;

import java.lang.reflect.ParameterizedType;

/**
 * @program: learn-mybatis-plus
 * @ClassName: LogAbstractServiceImpl
 * @description: 基础函数
 * @author: AlanMa
 * @create: 2019-05-13 09:33
 */
public abstract class LogAbstractServiceImpl<T> implements LogAbstractService<T> {

    /**
     * @Author AlanMa
     * @Description 获取泛型的Class对象
     * @Date 2019/5/13
     * @Param []
     * @return java.lang.Class<T>
     */
    public Class<T> getClz() {
        return ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
    }

    /**
     * @Author AlanMa
     * @Description 创建数据源实体类
     * @Date 2019/5/13
     * @Param [body]
     * @return T
     */
    public T generate(String body) {
        return JSON.parseObject(body, getClz());
    }

    @Override
    public void logPrint(String... strings){
        System.out.println("LogAbstractServiceImpl...");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    @Override
    public void Olog(T t) {
        System.out.println("------------------------------------------------");
    }
}