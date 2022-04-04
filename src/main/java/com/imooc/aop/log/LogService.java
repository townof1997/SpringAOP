package com.imooc.aop.log;

import com.imooc.aop.security.AdminOnly;
import org.springframework.stereotype.Component;

/**
 * @program: com.imooc.aop.log
 * @description:
 * @author: 86138_town
 * @create date: 2022/4/4 15 11
 */
@Component
public class LogService implements Loggable{
    @Override
    @AdminOnly
    public void log() {
        System.out.println("log from LogService");
    }
}
