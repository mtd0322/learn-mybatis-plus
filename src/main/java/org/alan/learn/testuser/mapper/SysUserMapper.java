package org.alan.learn.testuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.alan.learn.testuser.entity.SysUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AlanMa
 * @since 2019-05-08
 */
@Repository
@MapperScan
public interface SysUserMapper extends BaseMapper<SysUser> {

    Page<SysUser> findAllSysUserPage(Page<SysUser> page);

    @Select("select * from t_sys_user where name = #{name}")
    @Results({
            @Result(column="mailbox",property="mailbox"),
    })
    List<SysUser> findByName(String name);
}
