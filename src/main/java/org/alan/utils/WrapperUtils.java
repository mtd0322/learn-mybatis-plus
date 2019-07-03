package org.alan.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.alan.commons.annotation.audit.LastModifiedBy;
import org.alan.commons.annotation.audit.LastModifiedDate;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @program: learn-mybatis-plus
 * @ClassName: WrapperUtils
 * @description: 工具类
 * @author: AlanMa
 * @create: 2019-05-15 18:00
 */
public class WrapperUtils {

    public QueryWrapper getQuery(Class<?> cls, Map<String,Object> params) {

        QueryWrapper queryWrapper = new QueryWrapper();
        Field[] fields = FieldUtils.getAllFields(cls);

        for (Field field : fields) {
            if (params.containsKey(field)) {
                queryWrapper.eq(field, params.get(field));
            }
        }
        return queryWrapper;
    }

}