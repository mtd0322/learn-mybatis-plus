package org.alan.filter;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

/**
 * @program: learn-more
 * @ClassName: ApiRequestBody
 * @description: 请求接口拦截
 * @author: AlanMa
 * @create: 2019-04-15 10:00
 */
@RestControllerAdvice
public class ApiRequestBody extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;
    }
}