package org.alan.exception;

import java.util.Map;

/**
 * @program: learn-mybatis-plus
 * @ClassName: BaseException
 * @description: 自定义异常
 * @author: AlanMa
 * @create: 2019-05-16 18:20
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = -1624206726332133105L;
    private String code;
    private String message;
    private Map<String, Object> attrs;

    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, String message, Map<String, Object> attrs) {
        this.code = code;
        this.message = message;
        this.attrs = attrs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
    }
}