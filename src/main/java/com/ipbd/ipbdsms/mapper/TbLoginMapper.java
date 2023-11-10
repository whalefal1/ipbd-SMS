package com.ipbd.ipbdsms.mapper;

import com.ipbd.ipbdsms.entity.TbLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 李朋逊
* @description 针对表【tb_login(登录表
- super（最高级）
- admin（组长）)】的数据库操作Mapper
* @createDate 2023-11-10 19:49:42
* @Entity generator.entity.TbLogin
*/
@Mapper
public interface TbLoginMapper extends BaseMapper<TbLogin> {

    List<TbLogin> selectPasswordByUsername(String username);

}




