package org.alan.commons.annotation;

import org.alan.commons.enums.LogOperationEnum;
import org.alan.commons.enums.SysModuleEnum;

import java.lang.annotation.*;

/**
 * @program: learn-more
 * @InterfaceName: LearnLogger
 * @description: 日志注解
 * @author: AlanMa
 * @create: 2019-04-16 12:59
 */

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface LearnLogger {

    /**
     * 方法描述,可使用占位符获取参数:{{tel}}
     */
    String detail() default "无";

    /**
     * 模块名
     */
    SysModuleEnum sysModuleEnum();

    /**
     * 操作类型(enum):主要是select,insert,update,delete
     */
    LogOperationEnum operationTypeEnum() default LogOperationEnum.UNKNOWN;
}
