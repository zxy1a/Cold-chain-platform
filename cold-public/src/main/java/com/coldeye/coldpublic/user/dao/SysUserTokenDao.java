package com.coldeye.coldpublic.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coldeye.coldpublic.user.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);

    void deleteByToken(String token);
}
