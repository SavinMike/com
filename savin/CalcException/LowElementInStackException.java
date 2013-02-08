package com.savin.CalcException;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class LowElementInStackException extends CmdException {
    public String toString(){
        return "В стеке нехватает переменных";
    }
}
