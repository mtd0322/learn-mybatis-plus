package org.alan.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: learn-more
 * @ClassName: InitRoleMenu
 * @description: 初始化角色菜单
 * @author: AlanMa
 * @create: 2019-04-12 13:25
 */

@Component
public class InitRoleMenu implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println("################# CommandLineRunner #####################");
    }
}