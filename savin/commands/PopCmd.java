package com.savin.commands;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class PopCmd implements Command {
    @In(ElementOfAnnotation.STACK)
    private Stack<Double> stack;
    public  void execute(String arg) {

            stack.pop();


    }
}
