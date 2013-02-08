package com.savin.commands;

import org.omg.CORBA.BAD_CONTEXT;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 07.02.13
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
enum ElementOfAnatation{
    STACK,
    CONTEXT;
}
@Retention(RetentionPolicy.RUNTIME)
public @interface In {
    ElementOfAnatation[] value();

}
