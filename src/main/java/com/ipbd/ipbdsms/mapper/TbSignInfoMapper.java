package com.ipbd.ipbdsms.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipbd.ipbdsms.entity.TbSignInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 李朋逊
* @description 针对表【tb_sign_info(签到信息（记录每个学生，在签到天时的签到状况）)】的数据库操作Mapper
* @createDate 2023-12-07 20:33:40
* @Entity com.ipbd.ipbdsms.entity.TbSignInfo
*/
@Mapper
public interface TbSignInfoMapper extends BaseMapper<TbSignInfo> {

    public boolean saveSignInfoList(List<TbSignInfo> tbSignInfoList);

}
