package com.coldeye.coldadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.admin.entity.HostEntity;
import com.coldeye.coldpublic.utils.PageUtils;

import java.util.Map;

public interface HostService extends IService<HostEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
