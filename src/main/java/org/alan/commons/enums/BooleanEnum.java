package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: learn-more
 * @EnumName: BooleanEnum
 * @description: 认证状态
 * @author: AlanMa
 * @create: 2019-04-23 16:34
 */
@AllArgsConstructor
@Getter
@JSONType(serializeEnumAsJavaBean = true)
public enum BooleanEnum {

    /**
     * @Author AlanMa
     * @Description 所有用户模块
     * @Date 2019/4/18
     */
    YES("是"),
    NO("否")

    ;
    private String name;
}
