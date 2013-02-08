package com.savin.commands;

import com.savin.CalcException.CmdException;
import com.savin.CalcException.NegativeNumberException;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;
import java.math.*;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class SqrtCmd extends ValidateCmd implements Command {
    public  void execute(String arg,Stack<Double> stack, Map<String,Double> define) throws CmdException{

           if(!negativeNumber(stack))
                stack.push(Math.sqrt(stack.pop()));
           else
               throw new NegativeNumberException();


    }

}
