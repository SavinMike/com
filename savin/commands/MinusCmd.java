package com.savin.commands;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:41
 * To change this template use File | Settings | File Templates.
 */
public class MinusCmd extends ValidateCmd implements Command {
    private double a;
    private double b;
    public void execute(String arg,Stack<Double> stack, Map<String,Double> define){
        try {

            if(!lowElementInStack(stack)){
                a=stack.pop();
                b=stack.pop();
                stack.push(a-b);
            }
            else
                System.out.println("В стеке нехватает переменных");
        }
        catch (EmptyStackException e){
            System.out.println("Стек пуст");
            return;
        }
    }
}
