package com.ipbd.ipbdsms.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ipbd.ipbdsms.entity.SignInfoDto;
import com.ipbd.ipbdsms.entity.TbSignInfo;

import java.util.Map;

/**
* @author 李朋逊
* @description 针对表【tb_sign_info(签到信息（记录每个学生，在签到天时的签到状况）)】的数据库操作Service
* @createDate 2023-12-07 20:33:40
*/
public interface TbSignInfoService extends IService<TbSignInfo> {

    public boolean saveSignInfo(Map<Integer, SignInfoDto> signInfoMap);
}
