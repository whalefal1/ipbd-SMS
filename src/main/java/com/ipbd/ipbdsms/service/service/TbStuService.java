package com.ipbd.ipbdsms.service.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ipbd.ipbdsms.entity.TbStu;

import java.util.List;

/**
* @author 李朋逊
* @description 针对表【tb_stu(学生信息表)】的数据库操作Service
* @createDate 2023-12-04 16:01:22
*/
public interface TbStuService extends IService<TbStu> {



    public List<TbStu> selectGroupMember(String group);
}
