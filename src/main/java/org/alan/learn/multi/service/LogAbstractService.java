package org.alan.learn.multi.service;

/**
 * @program: learn-mybatis-plus
 * @InterfaceName: LogAbstractService
 * @description: 日志抽象函数
 * @author: AlanMa
 * @create: 2019-05-13 09:31
 */
public interface LogAbstractService<T> {

    /**
     * @Author AlanMa
     * @Description 打印
     * @Date 2019/5/13
     * @Param [strings]
     * @return void
     */
    void logPrint(String... strings);

    void Olog(T t);
}
