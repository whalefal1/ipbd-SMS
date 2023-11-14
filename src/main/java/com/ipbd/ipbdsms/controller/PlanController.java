package com.ipbd.ipbdsms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipbd.ipbdsms.common.R;
import com.ipbd.ipbdsms.entity.TbPlan;
import com.ipbd.ipbdsms.entity.TbPlanDto;
import com.ipbd.ipbdsms.service.service.TbPlanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private TbPlanService   tbPlanService;



    @GetMapping("/page")
    public R<Page> page(Long page, Long pageSize){
        return R.success(tbPlanService.pageDto(page,pageSize));
    }


    @DeleteMapping
    public R<String> delete(Long ids){
        log.info("id为{}",ids);
        tbPlanService.removeById(ids);
        return R.success("分类信息删除成功");
    }


    @PutMapping
    public R<String>  update(@RequestBody TbPlan tbplan){
        log.info("修改分类信息，{}",tbplan);
        UpdateWrapper<TbPlan> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",tbplan.getId());
        tbPlanService.update(tbplan,updateWrapper);
        return R.success("修改分类信息成功");
    }

    @PostMapping
    public R<String> save(@RequestBody TbPlanDto tbPlanDto){
        log.info("tbPlan:{}",tbPlanDto);
      if(!tbPlanService.savePlanByName(tbPlanDto)) {
          return R.error("新增分类失败");
      }
        return R.success("新增分类成功");
    }
}
