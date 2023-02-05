package com.coldeye.coldpublic.user.entity;

import lombok.Data;

/**
 * 登录表单
 *
 *
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
