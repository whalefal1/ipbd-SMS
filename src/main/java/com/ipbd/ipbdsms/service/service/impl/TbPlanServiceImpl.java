package com.ipbd.ipbdsms.service.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ipbd.ipbdsms.entity.TbPlan;
import com.ipbd.ipbdsms.entity.TbPlanDto;
import com.ipbd.ipbdsms.entity.TbStu;
import com.ipbd.ipbdsms.service.service.TbPlanService;
import com.ipbd.ipbdsms.mapper.TbPlanMapper;
import com.ipbd.ipbdsms.service.service.TbStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 李朋逊
* @description 针对表【tb_plan(计划表)】的数据库操作Service实现
* @createDate 2023-12-04 20:29:12
*/
@Service
public class TbPlanServiceImpl extends ServiceImpl<TbPlanMapper, TbPlan>
implements TbPlanService{

    @Autowired
    private TbStuService  tbStuService;

    @Autowired
    private TbPlanMapper tbPlanMapper;
    @Override
    public Page pageDto(Long page, Long pageSize) {
        List<TbPlan> records = tbPlanMapper.selectList(null);
        //获取学生信息
        List<TbStu> tbStus = tbStuService.list();
        System.out.println(tbStus);
        //将学生信息转换为Map
        Map<Integer, TbStu> tbStuMap = tbStus.stream().collect(
                Collectors.toMap(TbStu::getId, tbStu -> tbStu));
        //将计划信息转换为Dto
        List<TbPlanDto> tbPlanDtos = records.stream().map(tbPlan -> {
            TbPlanDto tbPlanDto = new TbPlanDto();
            TbStu tbStu = tbStuMap.get(tbPlan.getStuId());
            tbPlanDto.setId(tbPlan.getId());
            tbPlanDto.setStuName(tbStu.getStuName());
            tbPlanDto.setStuGrade(tbStu.getStuGrade());
            tbPlanDto.setStuGroup(tbStu.getStuGroup());
            tbPlanDto.setThisWeekLearning(tbPlan.getThisWeekLearning());
            tbPlanDto.setNextWeekPlan(tbPlan.getNextWeekPlan());
            tbPlanDto.setWeek(tbPlan.getWeek());
            return tbPlanDto;
        }).collect(Collectors.toList());
        //将Dto设置到分页对象中
        Page<TbPlanDto> pageInfo = new Page<>(page,pageSize);
        pageInfo.setTotal(tbPlanDtos.size());
        return pageInfo.setRecords(tbPlanDtos);
    }

    @Override
    public boolean savePlanByName(TbPlanDto tbPlanDto) {

        LambdaQueryWrapper<TbStu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbStu::getStuName,tbPlanDto.getStuName());
        TbStu tbStu = tbStuService.getOne(queryWrapper);
        if(tbStu != null) {
            TbPlan tbPlan = new TbPlan();
            tbPlan.setStuId(tbStu.getId());
            tbPlan.setThisWeekLearning(tbPlanDto.getThisWeekLearning());
            tbPlan.setNextWeekPlan(tbPlanDto.getNextWeekPlan());
            tbPlan.setWeek(tbPlanDto.getWeek());
            tbPlanMapper.insert(tbPlan);
            return true;
        }
        return false;
    }
}
