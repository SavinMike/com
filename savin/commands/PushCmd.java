package com.savin.commands;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
public class PushCmd implements Command {
    @In(ElementOfAnnotation.STACK)
    private Stack<Double> stack;
    @SuppressWarnings("unused")
    @In(ElementOfAnnotation.CONTEXT)
    private Map<String,Double> define;
    public void execute(String arg){
        if(define.containsKey(arg))
            stack.push(define.get(arg));
        else
            stack.push(Double.valueOf(arg));
    }
}
