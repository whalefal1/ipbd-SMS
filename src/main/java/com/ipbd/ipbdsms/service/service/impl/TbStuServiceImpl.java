package com.ipbd.ipbdsms.service.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ipbd.ipbdsms.entity.TbStu;
import com.ipbd.ipbdsms.mapper.TbStuMapper;
import com.ipbd.ipbdsms.service.service.TbStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 李朋逊
* @description 针对表【tb_stu(学生信息表)】的数据库操作Service实现
* @createDate 2023-12-04 16:01:22
*/
@Service
public class TbStuServiceImpl extends ServiceImpl<TbStuMapper, TbStu>
implements TbStuService {
    @Autowired
    private TbStuMapper tbStuMapper;
    @Override
    public List<TbStu> selectGroupMember(String group) {
        List<TbStu> tbStus = tbStuMapper.selectGroupMember(group);
        return tbStus;
    }
}
