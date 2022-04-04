package com.imooc.aop.domain;

/**
 * @program: SpringAOP.com.imooc.aop.domain
 * @description:
 * @author: 86138_town
 * @create date: 2022/3/30 22 29
 */

public class Product {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
