package com.savin.commands;

import com.savin.calculator.Info;

import java.util.HashMap;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 07.02.13
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */
public class CmdFactory{
    private HashMap<String,Command> guruTable=new HashMap<>();
    public HashMap<String,Command> getCmd(){
      return guruTable;
    }
    public CmdFactory (InitCommands c){
        try{
        Properties p= Info.getProperties();
        for(String cmd:p.stringPropertyNames()){

                Command value = (Command) Class.forName(p.getProperty(cmd)).newInstance();
                c.init(value);


                guruTable.put(cmd.trim(), value);


        }
        }catch (ClassNotFoundException | InstantiationException |IllegalAccessException  e){
            System.out.println(e);
        }
    }
}
