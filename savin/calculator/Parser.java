package com.savin.calculator;

import com.savin.CalcException.CmdException;
import com.savin.commands.CmdFactory;


/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 9:24
 * To change this template use File | Settings | File Templates.
 */
public class Parser {
    public static void parser(String s,CmdFactory cmdFactory) throws CmdException{
        try {
            if(s.trim().indexOf("#")==0){

            }
            else
                if (s.trim().indexOf(' ')>0 && cmdFactory.getCmd().containsKey(s.trim().toLowerCase().substring(0,s.trim().indexOf(' '))))

                    cmdFactory.getCmd().get(s.trim().toLowerCase()
                            .substring(0,s.trim().indexOf(' ')))
                            .execute(s.trim()
                                    .substring(s.trim().indexOf(' ')+1)
                                   );
                else if(cmdFactory.getCmd().containsKey(s.toLowerCase().trim())){
                    cmdFactory.getCmd().get(s.toLowerCase().trim())
                            .execute(s.trim().toLowerCase());


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
