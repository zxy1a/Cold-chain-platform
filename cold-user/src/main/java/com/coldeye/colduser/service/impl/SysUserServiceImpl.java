package com.coldeye.colduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coldeye.coldpublic.user.dao.SysUserDao;
import com.coldeye.coldpublic.user.entity.SysUserEntity;
import com.coldeye.colduser.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public SysUserEntity queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }
}
