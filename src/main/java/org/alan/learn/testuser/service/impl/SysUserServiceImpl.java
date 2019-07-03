package org.alan.learn.testuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.alan.commons.model.ResultData;
import org.alan.configure.SpringContextUtil;
import org.alan.exception.BaseException;
import org.alan.learn.testuser.entity.SysUser;
import org.alan.learn.testuser.mapper.SysUserMapper;
import org.alan.learn.testuser.service.ISysUserService;
import org.alan.utils.GetField;
import org.alan.utils.ResultDataUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AlanMa
 * @since 2019-05-08
 */
@Service
@Transactional(propagation= Propagation.NESTED,isolation= Isolation.DEFAULT,rollbackFor=Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public IPage<SysUser> selectUserPage(Page<SysUser> page,SysUser sysUser) {

        return sysUserMapper.selectPage(page,new QueryWrapper<>(sysUser));
    }

    @Override
    public ResultData<SysUser> saveSysUser(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
        return ResultDataUtil.setSuccessResult();
    }
    @Override
    public ResultData<SysUser> updateSysUser(Long id, SysUser sysUser) {

        SysUser sysUserCurrent = sysUserMapper.selectById(id);
        String[] ignoreProperties = GetField.getIsNullFields(sysUser);
        BeanUtils.copyProperties(sysUser,sysUserCurrent,ignoreProperties);
//        SpringContextUtil.getBean(this.getClass()).update(sysUserCurrent,new UpdateWrapper<SysUser>().eq("id",id));
//        sysUser.setName("1231231");
        boolean isSuccess = SpringContextUtil.getBean(this.getClass()).update(sysUserCurrent,new UpdateWrapper<SysUser>().eq("id",id));
        if (isSuccess) {
            int a = 1/0;
//            throw new BaseException("400","asdf");
//            return ResultDataUtil.setSuccessResult(sysUserCurrent);
        }
        return ResultDataUtil.setSuccessResult();
    }

}
