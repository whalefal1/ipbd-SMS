package com.ipbd.ipbdsms.service.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ipbd.ipbdsms.common.CommonConstant;
import com.ipbd.ipbdsms.config.CheckPermissionConfig;
import com.ipbd.ipbdsms.entity.TbLogin;
import com.ipbd.ipbdsms.service.service.TbLoginService;
import com.ipbd.ipbdsms.mapper.TbLoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
* @author 李朋逊
* @description 针对表【tb_login(登录表
- super（最高级）
- admin（组长）)】的数据库操作Service实现
* @createDate 2023-11-10 19:49:42
*/
@Service
@Slf4j
public class TbLoginServiceImpl extends ServiceImpl<TbLoginMapper, TbLogin>
    implements TbLoginService {

    @Autowired
    private TbLoginMapper tbLoginMapper;
    @Autowired
    private CheckPermissionConfig checkPermissionConfig;

    @Override
    public String login(String username, String password) throws NoSuchAlgorithmException {
        List<TbLogin> tbLogins = tbLoginMapper.selectPasswordByUsername("'" + username + "'");
        //获取所有用户名和密码
        if(tbLogins.size()==0) {
            return CommonConstant.LOGIN_RESPONSE_USERNAME;
        }
        //遍历所有用户名和密码
        for (TbLogin tbLogin : tbLogins) {
            //如果用户名和密码都匹配
            if(tbLogin.getRole() == 1 && tbLogin.getPassword().equals(encrypt(password))) {
                //登录成功
                StpUtil.login("admin");
                StpUtil.getSession().set("authList", checkPermissionConfig.getPermissionList("admin", null));
                log.info("admin{}登录",username);
                return CommonConstant.LOGIN_RESPONSE_SUCCESS;
            }
            if(tbLogin.getRole() == 0 && tbLogin.getPassword().equals(encrypt(password))) {
                //登录成功
                StpUtil.login("super");
                StpUtil.getSession().set("authList", checkPermissionConfig.getPermissionList("super", null));
                log.info("super:{}登录",username);
                return CommonConstant.LOGIN_RESPONSE_SUCCESS;
            }
        }
        return CommonConstant.LOGIN_RESPONSE_PASSWORD;
    }


    //加密密码
    public String encrypt(String password) throws NoSuchAlgorithmException {
        String SALT = "ipbd";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        md.update(SALT.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}




