package org.alan.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @program: learn-more
 * @ClassName: ApplicatInit
 * @description: 系统初始化
 * @author: AlanMa
 * @create: 2019-04-12 13:42
 */
@Component
public class ApplicationData implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("################# ApplicationRunner #####################");
    }
}