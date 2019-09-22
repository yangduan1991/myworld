package com.yangduan.ionian.reflect.demo1;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("----- before -----");
        Object result = method.invoke(target, args);
        System.out.println("----- after -----");
        return result;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(
                userService);

        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();

        String path = "C:/tmp/$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",
                UserServiceImpl.class.getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
