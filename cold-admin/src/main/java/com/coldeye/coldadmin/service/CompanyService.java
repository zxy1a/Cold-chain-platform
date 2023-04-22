package com.coldeye.coldadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.admin.entity.CompanyEntity;
import com.coldeye.coldpublic.utils.PageUtils;

import java.util.Map;

public interface CompanyService extends IService<CompanyEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
