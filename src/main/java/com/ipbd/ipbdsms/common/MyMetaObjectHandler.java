package com.ipbd.ipbdsms.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 元对象处理器
 *
 *用于进行公共字段(createTime,updateTime等)的填充：
 * 1.@TableField注解
 * 2.MetaObjectHandler类重写
 *
 * @author 李朋逊
 * @date 2023/06/18
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /*
    插入操作自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime",LocalDateTime.now());

    }

    /*
    修改操作自动填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]");
        log.info(metaObject.toString());
        metaObject.setValue("updateTime",LocalDateTime.now());
        log.info("公共字段填充执行完毕");
    }
}
