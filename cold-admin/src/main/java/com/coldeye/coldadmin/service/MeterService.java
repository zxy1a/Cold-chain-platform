package com.coldeye.coldadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.admin.entity.MeterEntity;
import com.coldeye.coldpublic.utils.PageUtils;

import java.util.Map;

public interface MeterService extends IService<MeterEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
