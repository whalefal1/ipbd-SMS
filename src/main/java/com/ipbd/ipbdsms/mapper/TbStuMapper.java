package com.ipbd.ipbdsms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipbd.ipbdsms.entity.TbStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
* @author 李朋逊
* @description 针对表【tb_stu(学生信息表)】的数据库操作Mapper
* @createDate 2023-12-04 16:01:22
* @Entity com.ipbd.ipbdsms.entity.TbStu
*/
@Mapper
public interface TbStuMapper extends BaseMapper<TbStu> {

    public List<TbStu> selectGroupMember(String group);

}
