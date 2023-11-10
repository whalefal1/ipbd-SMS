package com.ipbd.ipbdsms.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.ipbd.ipbdsms.common.R;
import com.ipbd.ipbdsms.service.service.TbLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping
@Tag(name = "登录接口")
@Slf4j
public class LoginController  {
    @Autowired
    private TbLoginService tbLoginService;

    @Operation(summary = "登录接口")
    @PostMapping("/login")
    public R login(@RequestBody Map<String,String> user) throws NoSuchAlgorithmException {
        log.info("username:{}",user.get("username"));
        return R.ok(tbLoginService.login(user.get("username"), user.get("password")));
    }

    @PostMapping("/logout")
    @Operation(summary = "退出接口")
    public R logout() {
        StpUtil.logout(StpUtil.getLoginId());
        return R.ok("退出成功");
    }


    @GetMapping("/test")
    @Operation(summary = "鉴权功能测试")
    @SaCheckPermission("admin:add")
    public R test(){
        return R.ok("鉴权功能测试成功");
    }



}
