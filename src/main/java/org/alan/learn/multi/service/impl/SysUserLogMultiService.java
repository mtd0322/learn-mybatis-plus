package org.alan.learn.multi.service.impl;

import org.alan.learn.multi.model.SysUser;
import org.alan.learn.multi.service.LogMultiService;
import org.springframework.stereotype.Service;

/**
 * @program: learn-mybatis-plus
 * @ClassName: SysUserLogMultiService
 * @description: 系统日志
 * @author: AlanMa
 * @create: 2019-05-13 09:25
 */
@Service("sysUserLogMultiService")
public class SysUserLogMultiService extends LogAbstractServiceImpl<SysUser> implements LogMultiService<SysUser> {

    /**
     * @Author AlanMa
     * @Description 接口方法
     * @Date 2019/5/13
     * @Param [s]
     * @return java.lang.String
     */
    @Override
    public String test(String s) {
        String out = s+"#"+this.getClass()+"#"+getClz();
        System.out.println(out);
        return "AdminUserLogMultiService"  + "###" + s;
    }
}