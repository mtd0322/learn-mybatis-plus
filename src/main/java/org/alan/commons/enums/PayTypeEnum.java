package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: learn-more
 * @EnumName: PayTypeEnum
 * @description: 支付类型
 * @author: AlanMa
 * @create: 2019-04-23 16:57
 */

@AllArgsConstructor
@Getter
@JSONType(serializeEnumAsJavaBean = true)
public enum PayTypeEnum {

    /**
     * @Author AlanMa
     * @Description 所有用户模块
     * @Date 2019/4/18
     */
    WEIXIN("微信"),
    ALIPAY("支付宝")

    ;
    private String name;
}
