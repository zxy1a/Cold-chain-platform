package com.coldeye.colduser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.user.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserService extends IService<SysUserEntity> {

    SysUserEntity queryByUserName(String username);
}
