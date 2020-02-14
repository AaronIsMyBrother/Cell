package com.eoogle.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

public class MyBatisPlusConfig {

    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
