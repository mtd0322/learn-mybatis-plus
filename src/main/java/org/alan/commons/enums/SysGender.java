package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: learn-more
 * @EnumName: SysGender
 * @description: 系统性别
 * @author: AlanMa
 * @create: 2019-04-22 14:29
 */

@AllArgsConstructor
@Getter
@JSONType(serializeEnumAsJavaBean = true)
public enum SysGender {

    /* 数据字典 */
    Sex_male(1,"男"),
    Sex_female(2,"女");

    private Integer id;
    private String  name;
}
