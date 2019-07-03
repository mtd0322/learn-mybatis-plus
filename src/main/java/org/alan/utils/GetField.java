package org.alan.utils;

import com.baomidou.mybatisplus.annotation.Version;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.alan.commons.annotation.audit.LastModifiedBy;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

/**
 * @program: learn-mybatis-plus
 * @ClassName: GetField
 * @description: 获取对象字段
 * @author: AlanMa
 * @create: 2019-05-16 11:02
 */
@Slf4j
public class GetField {



    public static String[] getIsNullFields(Object obj) {

        List<String> fieldList = Lists.newArrayList();
        Class objClass = obj.getClass();
        Field[] fields = FieldUtils.getAllFields(objClass);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object val = field.get(obj);
                if (Objects.isNull(val)) {
                    fieldList.add(field.getName());
                }
                if (AnnotationUtils.getAnnotation(field, Version.class) != null) {
                    fieldList.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
//        fieldList.forEach(a-> System.out.println(a));
        return fieldList.toArray(new String[0]);
    }

}