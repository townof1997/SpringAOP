package com.imooc.aop.security;

/**
 * @program: SpringAOP.com.imooc.aop.security
 * @description:
 * @author: 86138_town
 * @create date: 2022/3/30 22 34
 */
public class CurrentUserHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String get() {
        return holder.get()== null?"unknown":holder.get();
    }

    public static void set(String user) {
        holder.set(user);
    }
}

   