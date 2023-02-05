package com.coldeye.colduser.controller;

import com.coldeye.coldpublic.user.entity.SysLoginForm;
import com.coldeye.coldpublic.user.entity.SysUserEntity;
import com.coldeye.coldpublic.utils.Result;
import com.coldeye.colduser.service.SysUserService;
import com.coldeye.colduser.service.SysUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("sys/user")
public class SysLoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;


    /**
     * login
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form) throws IOException {
        String username = form.getUsername();
        SysUserEntity sysUserEntity = sysUserService.queryByUserName(username);

        if (sysUserEntity == null || !sysUserEntity.getPassword().equals(new Sha256Hash(form.getPassword(), sysUserEntity.getSalt()).toHex())) {
            return Result.error("账号或密码错误");
        }

        Result result = sysUserTokenService.createToken(sysUserEntity.getUserId());
        return result;
    }

    /**
     * logout
     */
    @PostMapping("/logout")
    public Result logout(@RequestHeader(value = "token") String token) {
        sysUserTokenService.logout(token);
        return Result.ok();
    }
}
