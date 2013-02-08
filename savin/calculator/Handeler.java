package com.savin.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class Handeler implements InvocationHandler {
    private Object obj;

    public Handeler(){ }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args)
            throws Throwable {
        System.out.println("Handeler invoke : " + method.getName());
        return method.invoke(obj, args) ;
    }

}
