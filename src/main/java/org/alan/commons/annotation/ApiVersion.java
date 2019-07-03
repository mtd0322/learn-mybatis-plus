package org.alan.commons.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @program: learn-more
 * @InterfaceName: ApiVersion
 * @description: 版本控制
 * @author: AlanMa
 * @create: 2019-04-19 13:18
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    int value();
}
