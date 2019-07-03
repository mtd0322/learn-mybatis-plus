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
public enum OrderStateEnum {

    /**
     * @Author AlanMa
     * @Description 订单状态 // 1.待支付 2.已支付 3.已取消 4.已失效  5.支付失败 6.已退款
     * @Date 2019/4/23
     */
    PAID_TOBO("待支付"),
    PAID_FINISH("已支付"),
    PAID_CANCELLED("已取消"),
    PAID_INVALID("已失效"),
    PAID_FAIL("支付失败"),
    PAID_REFUND("已退款");

    private String message;
}
