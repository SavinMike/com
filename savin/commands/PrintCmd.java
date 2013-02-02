package com.savin.commands;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class PrintCmd implements Command {
    public void execute(String arg,Stack<Double> stack, Map<String,Double> define){
        try{
            System.out.println(stack.peek());
        }
        catch (EmptyStackException e){
            System.out.println("Стек пуст");
            return;
        }
    }

}
