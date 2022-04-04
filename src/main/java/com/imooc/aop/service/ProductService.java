package com.imooc.aop.service;

import com.imooc.aop.domain.Product;
import com.imooc.aop.log.Loggable;
import com.imooc.aop.security.AdminOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: SpringAOP.com.imooc.aop.service
 * @description:
 * @author: 86138_town
 * @create date: 2022/3/30 22 32
 */
//@Service
@Component
public class ProductService {//implements Loggable

    @Autowired
    AuthService authService;

    @AdminOnly //加上AdminOnly注解之后就会执行SecurityAspect类的@Before注解
    public void insert(Product product) {
        //传统的硬编码对代码入侵有缺陷，如果还要进行很多关联操作的话，会很冗繁
//        authService.checkService();
        System.out.println("insert product");
    }

    @AdminOnly
    public void delete(Long id) {
//        authService.checkService();
        System.out.println("delete product id");
    }

    public void findById(Long id) {
        System.out.println("execute find by id");
    }

    public void findByTwoArgs(Long id, String name) {
        System.out.println("execute find by id and name");
    }

    public void getName() {
        System.out.println("execute get name");
    }

    public void exDemo() throws IllegalAccessException{
        System.out.println("execute ex demo");
    }

//    @Override
    public void log() {
        System.out.println("log from product service");
    }
}

   