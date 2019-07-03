package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: learn-more
 * @EnumName: LogOperationEnum
 * @description: 日志枚举
 * @author: AlanMa
 * @create: 2019-04-16 13:32
 */
@AllArgsConstructor
@Getter
@JSONType(serializeEnumAsJavaBean = true)
public enum LogOperationEnum {

    /**
     * @Author AlanMa
     * @Description 日志类型
     * @Date 2019/4/23
     */
    UNKNOWN("无"),
    DELETE("删除"),
    SELECT("查询"),
    UPDATE("更新"),
    SAVE("保存"),
    LIST("列表"),
    LIST_PAGER("分页列表")
    ;

    private String value;
}
