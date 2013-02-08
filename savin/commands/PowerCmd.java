package com.savin.commands;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
import com.savin.CalcException.LowElementInStackException;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

public class PowerCmd extends ValidateCmd implements  Command{

    public void execute(String arg,Stack<Double> stack, Map<String,Double> define) throws LowElementInStackException {
        double a;
        double b;

            if(!lowElementInStack(stack)){
                a=stack.pop();
                b=stack.pop();
                stack.push(Math.pow(a,b));
            }
            else
                throw new LowElementInStackException();


    }
}
