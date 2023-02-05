package com.coldeye.colduser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.user.entity.SysUserTokenEntity;
import com.coldeye.coldpublic.utils.Result;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysUserTokenService extends IService<SysUserTokenEntity> {
    /**
     * 生成token
     * @param userId  用户ID
     */
    Result createToken(long userId);

    /**
     * 退出，删除token记录
     */
    void logout(String token);
}
