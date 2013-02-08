package com.savin.commands;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 02.02.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
import com.savin.CalcException.CmdException;

import java.util.*;
public interface Command {
    void execute(String arg,Stack<Double> stack, Map<String,Double> define) throws CmdException;

}
