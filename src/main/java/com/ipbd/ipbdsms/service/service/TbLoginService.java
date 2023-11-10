package com.ipbd.ipbdsms.service.service;

import com.ipbd.ipbdsms.entity.TbLogin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
* @author 李朋逊
* @description 针对表【tb_login(登录表
- super（最高级）
- admin（组长）)】的数据库操作Service
* @createDate 2023-11-10 19:49:42
*/
public interface TbLoginService extends IService<TbLogin> {

    //登录
    public String login(String username, String password) throws NoSuchAlgorithmException;

}
