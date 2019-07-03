package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: learn-more
 * @EnumName: OrderStateEnum
 * @description: 订单状态
 * @author: AlanMa
 * @create: 2019-04-23 13:27
 */
@AllArgsConstructor
@Getter
@JSONType(serializeEnumAsJavaBean = true)
public enum OrderTypeEnum {

    /**
     * @Author AlanMa
     * @Description 订单状态
     * @Date 2019/4/23
     */
    INCREMENT_SERVICE("增值服务"),
    RECHARGE_SELF("钱包充值"),
    FACE_TO_FACE("当面付款"),
    ONLINE("在线付款"),

    ;

    private String message;
}
