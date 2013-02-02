package com.savin.commands;

import java.util.*;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class DefineCmd implements Command {
    private int index;
    public void execute(String arg,Stack<Double> stack, Map<String,Double> define){
        index=arg.indexOf(' ');
        define.put(arg.substring(0,index).trim(),
                Double.valueOf(arg.substring(index+1).trim()));
    }
}
