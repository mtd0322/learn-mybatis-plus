package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;

/**
 * @program: learn-more
 * @EnumName: GoodsPublishEnum
 * @description: 商品是否发布
 * @author: AlanMa
 * @create: 2019-04-23 16:25
 */
@AllArgsConstructor
@JSONType(serializeEnumAsJavaBean = true)
public enum GoodsPublishEnum {
    /**
     * @Author AlanMa
     * @Description 所有用户模块
     * @Date 2019/4/18
     */
    PUBLISH("已发布"),
    NO_PUBLISH("未发布")

    ;
    private String name;
}
