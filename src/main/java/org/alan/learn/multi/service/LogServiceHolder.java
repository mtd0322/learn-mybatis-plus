package org.alan.learn.multi.service;

import com.beust.jcommander.ParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: learn-mybatis-plus
 * @ClassName: LogServiceHolder
 * @description: 分发消息处理
 * @author: AlanMa
 * @create: 2019-05-13 11:21
 */
@Component
public class LogServiceHolder {

    @Autowired
    private Map<String, LogMultiService> multiServices;

    public LogMultiService findLogService(String type) {
        String name = type + LogMultiService.class.getSimpleName();
        LogMultiService service = multiServices.get(name);
        if (service == null) {
            throw new ParameterException("不支持当前类型");
        }
        return service;
    }
}