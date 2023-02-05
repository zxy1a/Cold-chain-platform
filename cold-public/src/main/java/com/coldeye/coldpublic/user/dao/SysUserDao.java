package com.coldeye.coldpublic.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coldeye.coldpublic.user.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);
}
