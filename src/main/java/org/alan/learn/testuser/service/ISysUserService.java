package org.alan.learn.testuser.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.alan.commons.model.ResultData;
import org.alan.learn.testuser.entity.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AlanMa
 * @since 2019-05-08
 */
public interface ISysUserService extends IService<SysUser> {

    IPage<SysUser> selectUserPage(Page<SysUser> page,SysUser sysUser);
    ResultData<SysUser> saveSysUser(SysUser sysUser);
    ResultData<SysUser> updateSysUser(Long id, SysUser sysUser);
}
