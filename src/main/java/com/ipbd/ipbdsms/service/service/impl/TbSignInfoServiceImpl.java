package com.ipbd.ipbdsms.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ipbd.ipbdsms.entity.SignInfoDto;
import com.ipbd.ipbdsms.entity.TbSignInfo;
import com.ipbd.ipbdsms.service.service.TbSignInfoService;
import com.ipbd.ipbdsms.mapper.TbSignInfoMapper;
import com.ipbd.ipbdsms.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author 李朋逊
* @description 针对表【tb_sign_info(签到信息（记录每个学生，在签到天时的签到状况）)】的数据库操作Service实现
* @createDate 2023-12-07 20:33:40
*/
@Service
@Slf4j
public class TbSignInfoServiceImpl extends ServiceImpl<TbSignInfoMapper, TbSignInfo>
implements TbSignInfoService{
    @Autowired
    private TbSignInfoMapper tbSignInfoMapper;

    private DateUtil dateUtil = new DateUtil();
    @Override
    public boolean saveSignInfo(Map<Integer, SignInfoDto> signInfoMap) {

        List<TbSignInfo> tbSignInfos = new ArrayList<>();
        for (Integer key : signInfoMap.keySet()) {
            SignInfoDto signInfo = signInfoMap.get(key);
            // 处理每个学生的签到信息
            TbSignInfo tbSignInfo = new TbSignInfo();
            tbSignInfo.setUserId(signInfo.getStuId());
            tbSignInfo.setSignUpRemark(signInfo.getSignUpRemark());
            tbSignInfo.setSignOutRemark(signInfo.getSignOutRemark());
            tbSignInfo.setStuWeek(dateUtil.getWeek());
            tbSignInfo.setStuYear(dateUtil.getYear());
            tbSignInfo.setSemester(dateUtil.getYear() + "上学年第" + dateUtil.getWeek() + "周");
            tbSignInfo.setStuWeekDay(dateUtil.getWeekDay());
            if (signInfo.getSignUp().equals("准时")) {
                tbSignInfo.setSignUpStatus(1);
            } else if (signInfo.getSignUp().equals("迟到")) {
                tbSignInfo.setSignUpStatus(2);
            } else if (signInfo.getSignUp().equals("请假")) {
                tbSignInfo.setSignUpStatus(3);
            }
            if (signInfo.getSignOut().equals("准时")) {
                tbSignInfo.setSignOutStatus(1);
            } else if (signInfo.getSignOut().equals("迟到")) {
                tbSignInfo.setSignOutStatus(2);
            } else if (signInfo.getSignOut().equals("请假")) {
                tbSignInfo.setSignOutStatus(3);
            }
            tbSignInfos.add(tbSignInfo);
        }
        log.info("tbSignInfos = {}",tbSignInfos);
        return tbSignInfoMapper.saveSignInfoList(tbSignInfos);
    }


}
