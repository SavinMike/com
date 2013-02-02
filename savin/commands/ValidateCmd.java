package com.savin.commands;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
import java.util.Stack;
abstract class ValidateCmd implements Command{

    protected boolean lowElementInStack(Stack<Double> stack){
       return (stack.size()<2) ? true : false;
    }

}
