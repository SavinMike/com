package com.savin.commands;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class PrintCmd implements Command {
    @In(ElementOfAnnotation.STACK)
    private Stack<Double> stack;
    public void execute(String arg){

            System.out.println(stack.peek());

    }

}
