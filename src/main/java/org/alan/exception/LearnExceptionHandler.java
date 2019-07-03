package org.alan.exception;

import com.google.common.collect.Maps;
import org.alan.commons.exception.CustomException;
import org.alan.commons.model.ResultData;
import org.alan.utils.ResultDataUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: learn-more
 * @ClassName: ExceptionHandler
 * @description: 异常统一处理
 * @author: AlanMa
 * @create: 2019-04-11 13:05
 */
@RestControllerAdvice
public class LearnExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultData exceptionHandler(Exception e){
        System.out.println("Exception:"+e);
        return ResultDataUtil.setResultData(999,e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    public ResultData exceptionHandler(CustomException e){
        System.out.println("CustomException:"+e);
        return ResultDataUtil.setResultData(e.getCode(),e.getMsg());
    }

    //shiro拦截未授权页面
    @ExceptionHandler(UnauthorizedException.class)
    public ResultData handleException(UnauthorizedException e) {
        return ResultDataUtil.setResultData(0,"未授权");
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResultData handleException2(AuthorizationException e) {
        return ResultDataUtil.setResultData(0,"未授权");
    }

    @ExceptionHandler(DisabledAccountException.class)
    public ResultData handleException3(DisabledAccountException e) {
        return ResultDataUtil.setResultData(0,"账户已被禁用");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResultData handleException4(DisabledAccountException e) {
        return ResultDataUtil.setResultData(0,"用户名或密码错误");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResultData validExceptionHandler(BindException e) {

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Map<String,String> paramsError = Maps.newHashMap();
        for (FieldError error:fieldErrors){
            paramsError.put(error.getField(),error.getDefaultMessage());
        }

        return ResultDataUtil.setSuccessResult(paramsError);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultData handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {

        return ResultDataUtil.setSuccessResult("缺少请求参数");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultData handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {

        return ResultDataUtil.setSuccessResult("参数解析失败");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultData handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Map<String,String> paramsError = Maps.newHashMap();
        for (FieldError error:fieldErrors){
            paramsError.put(error.getField(),error.getDefaultMessage());
        }
        return ResultDataUtil.setSuccessResult(paramsError);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultData handleServiceException(ConstraintViolationException e) {

        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return ResultDataUtil.setSuccessResult(message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResultData handleValidationException(ValidationException e) {
        return ResultDataUtil.setSuccessResult("参数验证失败");
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultData handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ResultDataUtil.setSuccessResult("不支持当前请求方法");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResultData handleHttpMediaTypeNotSupportedException(Exception e) {
        return ResultDataUtil.setSuccessResult("不支持当前媒体类型");
    }

    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResultData handleException(DataIntegrityViolationException e) {
        return ResultDataUtil.setSuccessResult("操作数据库出现异常：字段重复、有外键关联等");
    }
}