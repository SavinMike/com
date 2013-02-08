package com.savin.commands;

import com.savin.CalcException.CmdException;
import com.savin.CalcException.LowElementInStackException;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public class AddCmd extends ValidateCmd implements Command {

    @In(value = ElementOfAnatation.STACK)
    public void execute(String arg,Stack<Double> stack, Map<String,Double> define) throws CmdException {
        double a;
        double b;


            if(!lowElementInStack(stack)){
                a=stack.pop();
                b=stack.pop();
                stack.push(a+b);
            }
            else
                throw new LowElementInStackException();




    }

}
