package com.ipbd.ipbdsms.config;


import cn.dev33.satoken.stp.StpInterface;

import com.ipbd.ipbdsms.authority.AdminAuthority;
import com.ipbd.ipbdsms.authority.Authority;
import com.ipbd.ipbdsms.authority.SuperAuthority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * 注解鉴权类——定义权限
 * @author 李朋逊
 * @date 2023/11/07
 */
@Component
@Slf4j
public class CheckPermissionConfig implements StpInterface{
    //权限表
    HashMap<String, Authority> authorities = new HashMap<>();

    //定义权限表
    //user：普通用户权限
    //admin：管理员权限
    public CheckPermissionConfig() {
        authorities.put("super", new SuperAuthority());
        authorities.put("admin", new AdminAuthority());
    }

    /**
     * Description
     *获取权限
     */
    @Override
    public List<String> getPermissionList(Object loginName, String loginType) {
        return authorities.get(loginName).getAuthority();
    }

    /**
     * Description
     *定义用户角色
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
