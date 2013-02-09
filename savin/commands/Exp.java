package com.savin.commands;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class Exp implements Command {
    @In(ElementOfAnnotation.STACK)
    private Stack<Double> stack;
    public  void execute(String arg) {

                stack.push(Math.exp(stack.pop()));


    }
}
