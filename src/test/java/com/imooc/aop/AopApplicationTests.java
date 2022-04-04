package com.imooc.aop;

import com.imooc.aop.security.CurrentUserHolder;
import com.imooc.aop.service.ProductService;
import com.imooc.aop.service.sub.SubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopApplicationTests {

    @Autowired
    ProductService productService;

    @Autowired
    SubService subService;

    @Test
    public void contextLoads() {
    }

    @Test(expected = Exception.class)
    public void insertTest() {
        CurrentUserHolder.set("tom");
        productService.delete(1L);

    }

    @Test
    public void adminInsert() {
        CurrentUserHolder.set("admin");
        productService.delete(1L);
    }

    @Test
    public void test() {
        System.out.println("###begin test###");
        productService.findById(1L);
        productService.findByTwoArgs(1L, "hello");
        productService.getName();
        subService.demo();
        try{
            productService.exDemo();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
