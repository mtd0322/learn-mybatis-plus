package org.alan.commons.annotation.audit;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @program: learn-more
 * @InterfaceName: ApiVersion
 * @description: 版本控制
 * @author: AlanMa
 * @create: 2019-04-19 13:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
public @interface CreatedBy {
}
