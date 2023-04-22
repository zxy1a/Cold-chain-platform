package com.coldeye.coldadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coldeye.coldpublic.admin.entity.WarehouseEntity;
import com.coldeye.coldpublic.utils.PageUtils;

import java.util.Map;

public interface WarehouseService extends IService<WarehouseEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
