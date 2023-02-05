package com.coldeye.colduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coldeye.coldpublic.user.dao.SysUserTokenDao;
import com.coldeye.coldpublic.user.entity.SysUserTokenEntity;
import com.coldeye.coldpublic.utils.Result;
import com.coldeye.coldpublic.utils.TokenGenerator;
import com.coldeye.colduser.service.SysUserTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    private final static int EXPIRE = 3600 * 12;
    @Override
    public Result createToken(long userId) {
        String token = TokenGenerator.generateValue();
        Date date = new Date();
        Date expireTime = new Date(date.getTime() + EXPIRE * 1000);
        SysUserTokenEntity tokenEntity = this.getById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(date);
            tokenEntity.setExpireTime(expireTime);
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(date);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        Result r = Result.ok().put("token", token).put("expire", EXPIRE);
        return r;
    }

    @Override
    public void logout(String token) {
        this.getBaseMapper().deleteByToken(token);
    }
}
