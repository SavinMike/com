package com.savin.commands;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 07.02.13
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */
public class CmdFactory{
    private enum cmdEnum{
        AddCmd,DefineCmd,DivCmd,Exp,Log,MinusCmd,Multcmd,PopCmd,PowerCmd,PrintCmd,SqrtCmd;
        static public void add(String enu){

        }
    }
    public Command getCmd(cmdEnum type) throws ClassNotFoundException, InstantiationException,IllegalAccessException{
        return (Command)Class.forName(type.name()).newInstance();
        
    }
}
