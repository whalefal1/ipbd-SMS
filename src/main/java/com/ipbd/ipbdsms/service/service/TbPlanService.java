package com.ipbd.ipbdsms.service.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ipbd.ipbdsms.entity.TbPlan;
import com.ipbd.ipbdsms.entity.TbPlanDto;

/**
* @author 李朋逊
* @description 针对表【tb_plan(计划表)】的数据库操作Service
* @createDate 2023-12-04 20:29:12
*/
public interface TbPlanService extends IService<TbPlan> {

    public Page pageDto(Long page,Long pageSize);


    public boolean savePlanByName(TbPlanDto tbPlanDto);
}
