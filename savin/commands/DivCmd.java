package com.savin.commands;

import com.savin.CalcException.LowElementInStackException;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class DivCmd extends ValidateCmd implements Command{

    public void execute(String arg,Stack<Double> stack, Map<String,Double> define) throws LowElementInStackException {
        double a;
        double b;


            if(!lowElementInStack(stack)){
                a=stack.pop();
                b=stack.pop();
                stack.push(a/b);
            }
            else
                throw new LowElementInStackException();

    }

}
