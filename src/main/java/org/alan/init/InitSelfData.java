package org.alan.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @program: learn-more
 * @ClassName: InitSelfData
 * @description: 初始化私有数据
 * @author: AlanMa
 * @create: 2019-04-12 13:31
 */
@Component
public class InitSelfData implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("################# InitializingBean #####################");
    }
}