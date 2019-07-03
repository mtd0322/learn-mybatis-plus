package org.alan.commons.annotation.audit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: learn-more
 * @InterfaceName: ApiVersion
 * @description: 版本控制
 * @author: AlanMa
 * @create: 2019-04-19 13:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
public @interface LastModifiedDate {
}
