package com.savin.calculator;

import com.savin.CalcException.CmdException;
import com.savin.commands.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 9:24
 * To change this template use File | Settings | File Templates.
 */
public class Parser {
    public static void parser(String s, Map<String,Command> guruTable,Stack<Double> stack,Map<String,Double> define) throws CmdException{
        try {
            if(s.trim().indexOf("#")==0){

            }
            else
                if (s.trim().indexOf(' ')>0 && guruTable.containsKey(s.trim().toLowerCase().substring(0,s.trim().indexOf(' '))))

                    guruTable.get(s.trim().toLowerCase()
                            .substring(0,s.trim().indexOf(' ')))
                            .execute(s.trim()
                                    .substring(s.trim().indexOf(' ')+1),
                                    stack,define);
                else if(guruTable.containsKey(s.toLowerCase().trim())){
                    guruTable.get(s.toLowerCase().trim())
                            .execute(s.trim().toLowerCase(),stack,define);
                }
                else {
                    System.out.println("Комманда \"" +s+"\" не существует");
                    return;
                }
        }
        catch (NumberFormatException e){
            System.out.println("Строка \""+s+"\" не верна");
            return;
        }
    }
}
