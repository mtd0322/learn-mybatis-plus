package org.alan.filter;

import org.alan.commons.model.ResultData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @program: learn-more
 * @ClassName: ApiResponseBody
 * @description: 返回接口拦截
 * @author: AlanMa
 * @create: 2019-04-15 09:43
 */

@RestControllerAdvice
public class ApiResponseBody implements ResponseBodyAdvice<ResultData> {

    /**
     * @Author AlanMa
     * @Description 判断哪些需要拦截
     * @Date 2019/4/15
     * @Param [methodParameter, aClass]
     * @return boolean
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;
    }

    @Override
    public ResultData beforeBodyWrite(ResultData resultData, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        System.out.println("##################  ResponseBodyAdvice ###################"+resultData.toString());
        return resultData;
    }
}