package com.coldeye.coldadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coldeye.coldadmin.service.HostService;
import com.coldeye.coldpublic.admin.dao.HostDao;
import com.coldeye.coldpublic.admin.entity.HostEntity;
import com.coldeye.coldpublic.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HostServiceImpl extends ServiceImpl<HostDao, HostEntity> implements HostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int current = params.get("page")== null? 1 : Integer.valueOf(params.get("page").toString());
        int size = params.get("pagesize") == null? 10 : Integer.valueOf(params.get("pagesize").toString());

        Page<HostEntity> page = new Page<>(current, size);


        String housename = params.get("housename")==null ? "": params.get("housename").toString();
        QueryWrapper<HostEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(HostEntity::getHousename, housename)
                .orderByAsc(HostEntity::getHostname);

        IPage<HostEntity> result = this.page(page, wrapper);

        return new PageUtils(result);
    }

}
