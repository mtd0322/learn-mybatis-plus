package org.alan.learn.testuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.alan.commons.annotation.LearnLogger;
import org.alan.commons.enums.LogOperationEnum;
import org.alan.commons.enums.SysModuleEnum;
import org.alan.commons.model.ResultData;
import org.alan.learn.base.BaseController;
import org.alan.learn.testuser.entity.SysUser;
import org.alan.learn.testuser.service.impl.SysUserServiceImpl;
import org.alan.shiro.utils.SaltUtils;
import org.alan.utils.GetField;
import org.alan.utils.ResultDataUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AlanMa
 * @since 2019-05-08
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public IPage<SysUser> list(@RequestParam Integer size,
                               @RequestParam Integer current,
                               SysUser sysUser) {
        return sysUserService.selectUserPage(new Page<>(current, size),sysUser);
    }

    @LearnLogger(sysModuleEnum = SysModuleEnum.SysUser,detail = "",operationTypeEnum = LogOperationEnum.SAVE)
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public ResultData<SysUser> sysUserRegister(@Valid SysUser sysUser){

        String salt = SaltUtils.createSalt();
        String saltPassword = SaltUtils.MD5Salt(sysUser.getPassword(),salt);
        sysUser.setSaltValue(salt);
        sysUser.setPassword(saltPassword);
        return sysUserService.saveSysUser(sysUser);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResultData<SysUser> sysUserUpdate(@PathVariable Long id,
                                             SysUser sysUser){

        return sysUserService.updateSysUser(id,sysUser);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResultData<SysUser> sysUserDelete(@RequestParam Map params){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.allEq(params);

        boolean isSuccess = sysUserService.remove(queryWrapper);
        return ResultDataUtil.setSuccessResult(isSuccess);
    }

    @LearnLogger(sysModuleEnum = SysModuleEnum.SysUser,operationTypeEnum = LogOperationEnum.SELECT)
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public ResultData<SysUser> sysUserLogin(@Email String mail, String password){

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(mail, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            SysUser user = (SysUser) subject.getPrincipal();
            return ResultDataUtil.setSuccessResult(user);
        } catch (DisabledAccountException e) {
            return ResultDataUtil.setSuccessResult("账户已被禁用");
        } catch (AuthenticationException e) {
            return ResultDataUtil.setSuccessResult("用户名或密码错误");
        }
    }
}
