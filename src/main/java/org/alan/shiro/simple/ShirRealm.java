package org.alan.shiro.simple;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.alan.commons.model.ResultData;
import org.alan.learn.testuser.entity.SysUser;
import org.alan.learn.testuser.service.ISysUserService;
import org.alan.shiro.utils.SaltUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @program: learn-more
 * @ClassName: ShirRealm
 * @description: 自定义realm
 * @author: AlanMa
 * @create: 2019-05-07 14:34
 */
@Slf4j
@Component
public class ShirRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService userService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

//        String accessToken = (String) token.getPrincipal();
        String name = token.getUsername();
//        ResultData<SysUser> userLogin = null;
//        ResultData<SysUser> userLogin = userService.findSysUserByMailbox(name);

        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(SysUser::getMailbox,name);
        SysUser sysUser = userService.getOne(lambdaQueryWrapper);
        if (Objects.nonNull(sysUser)) {
            log.info("---------------- Shiro 凭证认证成功 ----------------------");
            ByteSource salt = ByteSource.Util.bytes(sysUser.getSaltValue());
            String saltPassword = SaltUtils.MD5Salt(token.getPassword(), sysUser.getSaltValue());
            if (!saltPassword.equals(sysUser.getPassword())) {
                throw new AuthenticationException();
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    sysUser,
                    token.getPassword(),
                    salt,
                    getName()
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof SysUser) {
            SysUser userLogin = (SysUser) principal;
            Set<String> roles = new HashSet<>();
            roles.add("admin");
//            Set<String> roles = userService.findRoleNameByUserId(userLogin.getId());
            authorizationInfo.addRoles(roles);

            Set<String> permissions = new HashSet<>();
            permissions.add("adminpermissions");
//            Set<String> permissions = userService.findPermissionsByUserId(userLogin.getId());
            authorizationInfo.addStringPermissions(permissions);
        }
        log.info("---- 获取到以下权限 ----");
        log.info(authorizationInfo.getStringPermissions().toString());
        log.info("---------------- Shiro 权限获取成功 ----------------------");
        return authorizationInfo;
    }
}