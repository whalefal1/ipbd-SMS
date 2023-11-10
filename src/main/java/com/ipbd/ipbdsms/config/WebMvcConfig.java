package com.ipbd.ipbdsms.config;

import com.ipbd.ipbdsms.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * web资源配置类
 * 配置web资源的映射关系
 *
 * @author 李朋逊
 * @date 2023/06/16
 */
@Configuration
@Slf4j
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * Description 配置静态资源映射
     *
     * @param registry 注册表
     * @author 李朋逊
     * @date 2023/06/16
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始进行静态资源映射. . .");
        /*
        路由中的http://localhost:8080/backend/.......会被映射到resource中的backend目录下对应的资源中
         */
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        /*
        路由中的http://localhost:8080/front/.......会被映射到resource中的front目录下对应的资源中
         */
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");


        log.info("运行成功...");
    }

    /**
     * Description 扩展mvc框架消息转换器
     *用于将后端响应的数据转换为String数据类型传给前端
     *
     * 注意：前后端数据交互的时候，因为mybatis-plus使用雪花算法处理id，
     * 这种Long型的数据类型在数据交互的时候可能会发生精度损失的情况，
     * 所以使用消息转换器将数据类型转换为String类型，避免精度损失
     * @param converters 转换器
     * @author 李朋逊
     * @date 2023/06/18
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器");
        //创建消息转换器
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
         //设置对象转换器
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //将以上消息转换器追加到mvc框架的转换器容器中
        converters.add(0,messageConverter);
    }
}