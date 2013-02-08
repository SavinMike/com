package com.savin.commands;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class Log implements Command {
    public  void execute(String arg,Stack<Double> stack, Map<String,Double> define) {

            stack.push(Math.log(stack.pop()));


    }
}
