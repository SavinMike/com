package com.savin.commands;

import java.util.*;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class PopCmd implements Command {
    public  void execute(String arg,Stack<Double> stack, Map<String,Double> define) {
        try {
            stack.pop();
        }
        catch (EmptyStackException e){
            System.out.println("Стек пуст");
            return;
        }

    }
}
