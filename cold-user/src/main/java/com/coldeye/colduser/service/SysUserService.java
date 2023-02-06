package com.coldeye.colduser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.user.entity.SysUserEntity;



public interface SysUserService extends IService<SysUserEntity> {

    SysUserEntity queryByUserName(String username);
}
