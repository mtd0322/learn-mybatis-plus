package org.alan.learn.multi.service.impl;

import org.alan.learn.multi.model.AdminUser;
import org.alan.learn.multi.service.LogMultiService;
import org.springframework.stereotype.Service;

/**
 * @program: learn-mybatis-plus
 * @ClassName: AdminUserLogMultiService
 * @description: 用户日志
 * @author: AlanMa
 * @create: 2019-05-13 09:26
 */
@Service("adminUserLogMultiService")
public class AdminUserLogMultiService extends LogAbstractServiceImpl<AdminUser> implements LogMultiService<AdminUser> {

    @Override
    public String test(String s) {
        String out = s+"#"+this.getClass()+"#"+getClz();
        System.out.println(out);
        return "AdminUserLogMultiService" + "###" + s;
    }

    @Override
    public void logPrint(String... strings) {

        System.out.println("AdminUserLogMultiService...");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}