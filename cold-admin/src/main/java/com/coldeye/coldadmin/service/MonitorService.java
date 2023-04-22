package com.coldeye.coldadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.admin.entity.MonitorEntity;
import com.coldeye.coldpublic.utils.PageUtils;

import java.util.Map;

public interface MonitorService extends IService<MonitorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}