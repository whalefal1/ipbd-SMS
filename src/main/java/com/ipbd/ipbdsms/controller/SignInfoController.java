package com.ipbd.ipbdsms.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipbd.ipbdsms.common.JacksonObjectMapper;
import com.ipbd.ipbdsms.common.R;
import com.ipbd.ipbdsms.entity.SignInfoDto;
import com.ipbd.ipbdsms.entity.TbStu;
import com.ipbd.ipbdsms.service.service.TbSignInfoService;
import com.ipbd.ipbdsms.service.service.TbStuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/group")
public class SignInfoController {

    @Autowired
    private TbStuService tbStuService;

    @Autowired
    private TbSignInfoService tbSignInfoService;

    @GetMapping("/{group}")
    public R<List<TbStu>> showGroupMember(@PathVariable String group){
        log.info("group = {}",group);
        List<TbStu> tbStus = tbStuService.selectGroupMember(group);
        log.info("tbStus = {}",tbStus);
        if(tbStus.size() != 0){
            return R.success(tbStus);
        }
        return R.error("查询失败");
    }


    @PostMapping
    public R<String> save(@RequestBody Map<Integer, SignInfoDto> signInfoMap){
        log.info("{}",signInfoMap);
        if(tbSignInfoService.saveSignInfo(signInfoMap)){
            return R.success("保存成功");
        }
        return R.error("保存失败");
    }
}
