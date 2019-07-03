package org.alan.learn.multi.service;

/**
 * @program: learn-mybatis-plus
 * @InterfaceName: LogMultiService
 * @description: 多种实现接口
 * @author: AlanMa
 * @create: 2019-05-13 09:24
 */
public interface LogMultiService<T> extends LogAbstractService<T>{
    
    /**
     * @Author AlanMa
     * @Description 接口抽象
     * @Date 2019/5/13
     * @Param [s]
     * @return java.lang.String
     */
    String test(String s);
}
