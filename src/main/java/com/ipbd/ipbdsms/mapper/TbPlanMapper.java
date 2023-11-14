package com.ipbd.ipbdsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipbd.ipbdsms.entity.TbPlan;
import org.apache.ibatis.annotations.Mapper;


/**
* @author 李朋逊
* @description 针对表【tb_plan(计划表)】的数据库操作Mapper
* @createDate 2023-12-04 20:29:12
* @Entity com.ipbd.ipbdsms.entity.TbPlan
*/
@Mapper
public interface TbPlanMapper extends BaseMapper<TbPlan> {


    void updateByUserId(TbPlan tbPlan);

}
