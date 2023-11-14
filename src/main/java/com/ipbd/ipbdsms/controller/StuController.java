package com.ipbd.ipbdsms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipbd.ipbdsms.common.R;
import com.ipbd.ipbdsms.entity.TbStu;
import com.ipbd.ipbdsms.service.service.TbStuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@RequestMapping("/student")
public class StuController {

    @Autowired
    private TbStuService tbStuService;

    /**
     * Description 员工信息分页查询
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link R }<{@link Page }>
     * @author 李朋逊
     * @date 2023/06/18
     */
    @GetMapping("/page")
    public R<Page> page (int page, int pageSize, String name){
        log.info("page = {},pageSize = {} , name = {}",page,pageSize,name);

        //创建分页构造器
        Page pageInfo = new Page(page,pageSize);

        //创建条件构造器
        LambdaQueryWrapper<TbStu> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件:当name不为空Employee时，查询employee表中name关键字下含有相应字符name的数据
        //相当于select from employee where name like queryName;
        queryWrapper.like(StringUtils.isNotEmpty(name),TbStu::getStuName,name);
        //添加排序条件-根据修改时间进行降序排序
        queryWrapper.orderByDesc(TbStu::getUpdateTime);
        //执行查询——根据queryWrapper进行条件查询，将查询到的数据封装到pageInfo对象中，pageInfo对象本身就已经定义了分页条件
        tbStuService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }



    /**
     * Description 新增学员方法
     *
     * @param request  请求
     * @param tbStu 员工
     * @return {@link R }<{@link String }>
     * @author 李朋逊
     * @date 2023/06/18
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody TbStu tbStu){
        log.info("新增员工，员工信息{}",tbStu.toString());
        //mybatis-plus封装方法
        tbStuService.save(tbStu);
        return R.success("新增员工成功");
    }


    /**
     * Description 根据id修改员工信息
     *
         * @param tbStu 员工
     * @return {@link R }<{@link String }>
     * @author 李朋逊
     * @date 2023/06/18
     */

    @PutMapping
    public R<String> update(@RequestBody TbStu tbStu){
        log.info(tbStu.toString());
        tbStuService.updateById(tbStu);
        return R.success("员工信息修改成功");
    }

    @GetMapping("/{id}")
    public R<TbStu> getById(@PathVariable Long id){
        log.info("根据id查询员工信息，{}",id);
        TbStu stu = tbStuService.getById(id);
        if(stu != null){
            return R.success(stu);
        }
        return R.error("为查询到员工");
    }
}
