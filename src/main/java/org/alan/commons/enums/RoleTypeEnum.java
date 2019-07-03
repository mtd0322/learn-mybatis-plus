package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: learn-more
 * @EnumName: RoleTypeEnum
 * @description: 初始化角色类型
 * @author: AlanMa
 * @create: 2019-04-24 10:52
 */
@AllArgsConstructor
@Getter
@JSONType(serializeEnumAsJavaBean = true)
public enum RoleTypeEnum {

    /**
     * @Author AlanMa
     * @Description 初始化角色类型
     * @Date 2019/4/18
     */
    Admin("管理员"),
    User("普通用户")
    ;
    private String name;
}
