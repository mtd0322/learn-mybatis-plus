package org.alan.commons.enums;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: learn-more
 * @EnumName: SysModuleEnum
 * @description: 模块
 * @author: AlanMa
 * @create: 2019-04-18 17:25
 */
@AllArgsConstructor
@Getter
@JSONType(serializeEnumAsJavaBean = true)
public enum SysModuleEnum {

    /**
     * @Author AlanMa
     * @Description 所有用户模块
     * @Date 2019/4/18
     */
    SysUser("用户管理"),
    SysRole("角色管理"),
    SysMenu("菜单管理"),
    SysTags("标签管理"),
    SysLogs("日志管理"),
    UserCards("证件管理")

    ;
    private String moduleName;
}
