package org.alan.commons.annotation.aspect;

import org.alan.commons.annotation.LearnLogger;
import org.alan.learn.testuser.entity.SysUser;
import org.alan.utils.GetSysUserUtils;
import org.alan.utils.HttpContextUtils;
import org.alan.utils.IpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @program: learn-more
 * @ClassName: LearnLoggerImpl
 * @description: 日志记录
 * @author: AlanMa
 * @create: 2019-04-16 13:12
 */
@Aspect
@Component
public class LearnLoggerImpl {

    @Pointcut("@annotation(org.alan.commons.annotation.LearnLogger)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("运行时间：" + time);
        saveLog(point,time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LearnLogger logAnnotation = method.getAnnotation(LearnLogger.class);

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        String params = "";
        if (args != null && paramNames != null) {
            for (int i = 0; i < args.length; i++) {
                params += " " + paramNames[i] + ": " + args[i];
            }
        }
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        SysUser sysUser = GetSysUserUtils.getCurrentLoginUser();
        String mail = "无";
        if (Objects.nonNull(sysUser)){
            mail = sysUser.getMailbox();
        }

        if (logAnnotation != null) {
            System.out.println("####################################################");
            System.out.println("IP：" + IpUtil.getClientAddress(request));
            System.out.println("用户名：" + mail);
            System.out.println("类名称：" + className);
            System.out.println("方法名：" + methodName);
            System.out.println("参数：" + params);
            System.out.println("动作：" + logAnnotation.operationTypeEnum().getValue());
            System.out.println("运行时间：" + time);
            System.out.println("模块名称：" + logAnnotation.sysModuleEnum().getModuleName());
            System.out.println("描述信息：" + logAnnotation.detail());
            System.out.println("####################################################");
        }
    }
}