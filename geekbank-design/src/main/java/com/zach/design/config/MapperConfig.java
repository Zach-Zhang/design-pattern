package com.zach.design.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;

/**
 * Created by Zach
 * Date :2020/10/12 22:09
 * Description :
 * Version :1.0
 */
@MapperScan("com.zach.design.**.mapper")
public class MapperConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
