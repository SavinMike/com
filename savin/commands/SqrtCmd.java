package com.savin.commands;

import com.savin.CalcException.CmdException;
import com.savin.CalcException.NegativeNumberException;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class SqrtCmd extends ValidateCmd implements Command {
    @In(ElementOfAnnotation.STACK)
    private Stack<Double> stack;
    public  void execute(String arg) throws CmdException{

           if(!negativeNumber(stack))
                stack.push(Math.sqrt(stack.pop()));
           else
               throw new NegativeNumberException();


    }

}
