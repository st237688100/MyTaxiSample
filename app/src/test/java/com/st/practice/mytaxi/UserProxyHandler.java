package com.st.practice.mytaxi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Date: 2019/4/9 10:56
 */
public class UserProxyHandler implements InvocationHandler {

    UserService realService;
    UserService proxyInstance;

    public UserProxyHandler(UserService userService) {
        realService = userService;
        /**
         * 关键点1：代理实例生成
         */
        proxyInstance = (UserService) Proxy.newProxyInstance(getClass().getClassLoader(), userService.getClass().getInterfaces(), this);
    }

    public UserService getRealService() {
        return realService;
    }

    public UserService getProxyInstance() {
        return proxyInstance;
    }

    /**
     * 关键点2：代理实例的接口方法会调用InvocationHandler的invoke方法
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("UserProxyHandler before");
        // 代理实现的地方
        Object result = method.invoke(realService, objects);
        System.out.println("UserProxyHandler after");
        return result;
    }

}
