package org.alan.configure;

import lombok.extern.slf4j.Slf4j;
import org.alan.commons.annotation.audit.CreatedBy;
import org.alan.commons.annotation.audit.CreatedDate;
import org.alan.commons.annotation.audit.LastModifiedBy;
import org.alan.commons.annotation.audit.LastModifiedDate;
import org.alan.learn.testuser.entity.SysUser;
import org.alan.utils.GetSysUserUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

/**
 * @program: learn-mybatis-plus
 * @ClassName: AuditingInterceptor
 * @description: 审计
 * @author: AlanMa
 * @create: 2019-05-08 13:52
 */
@Slf4j
@Component
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}) })
public class AuditingInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.error("#######################intercept#######################");

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
//        Field[] fields = parameter.getClass().getDeclaredFields();
        Field[] fields = FieldUtils.getAllFields(parameter.getClass());
        Date currentDate = new Date();
        SysUser sysUser = GetSysUserUtils.getCurrentLoginUser();
        if (Objects.isNull(sysUser)) {
            sysUser = new SysUser();
            sysUser.setName("无");
        }

        if(SqlCommandType.UPDATE==sqlCommandType) {

            log.error("####UPDATE...................................");
            for (Field field : fields) {
                log.error("####UPDATE............LastModifiedBy.......................");
                if (AnnotationUtils.getAnnotation(field, LastModifiedBy.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,sysUser.getName());
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, LastModifiedDate.class) != null) {
                    log.error("####UPDATE............LastModifiedDate.......................");
                    field.setAccessible(true);
                    field.set(parameter,currentDate);
                    field.setAccessible(false);
                }
            }
        } else if(SqlCommandType.INSERT==sqlCommandType){
            log.error("####INSERT...................................");
            for (Field field : fields) {
                    log.error(field.toString());
                if (AnnotationUtils.getAnnotation(field, CreatedBy.class) != null) {
                    log.error("####INSERT............CreatedBy.......................");
                    field.setAccessible(true);
                    field.set(parameter,sysUser.getName());
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, CreatedDate.class) != null) {
                    log.error("####INSERT............CreatedDate.......................");
                    field.setAccessible(true);
                    field.set(parameter,new Date());
                    field.setAccessible(false);
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }
}