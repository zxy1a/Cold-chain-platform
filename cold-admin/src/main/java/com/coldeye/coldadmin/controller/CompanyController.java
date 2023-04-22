package com.coldeye.coldadmin.controller;

import com.coldeye.coldadmin.service.CompanyService;
import com.coldeye.coldpublic.admin.entity.CompanyEntity;
import com.coldeye.coldpublic.utils.PageUtils;
import com.coldeye.coldpublic.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = companyService.queryPage(params);
        return Result.ok(page.getPageMap());
    }

    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id) {
        CompanyEntity companyEntity = companyService.getById(id);
        return Result.ok().put("company", companyEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody CompanyEntity company){
        String uuid = UUID.randomUUID().toString();
        company.setId(uuid);

        companyService.save(company);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody CompanyEntity company){
        companyService.updateById(company);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(String id){
        companyService.removeById(id);

        return Result.ok();
    }
}
