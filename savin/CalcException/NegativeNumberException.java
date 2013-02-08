package com.savin.CalcException;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
public class NegativeNumberException extends CmdException {
    public String toString(){
        return "Калькулятор не умеет брать квадратный корень от отрицательных чисел";

    }
}
