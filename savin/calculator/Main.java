package com.savin.calculator;

/**
 * Печать из команд плохо (System.out.println("В стеке нехватает переменных");) Команды должны сообщать калькулятору что произошло а его ответственность верным способом показать нужное сообщение. За исключением команд типа print. Смотрите сколько раз у вас встречается System.out.println("Стек пуст");  и представьте что стоит задача локализации приложения на другой язык (не русский). У вас получается каждая команда зависит от типа интерфейса (консольный или графический) и локализации приложения
 * СТЕКОВЫЙ КАЛЬКУЯТОР
 */
import java.io.*;
import java.util.*;

import com.savin.CalcException.CmdException;
import com.savin.CalcException.LowElementInStackException;
import com.savin.CalcException.NegativeNumberException;
import com.savin.commands.*;
import java.lang.reflect.Proxy;
public class Main {

    static public void  main(String args[]) throws  IOException{
        Map<String,Command> guruTable=new HashMap<>();
        String s="";
        Stack<Double> stack =new Stack<Double>();
        Map<String,Double> define=new HashMap<>();
        Properties p=Info.getProperties();
        //Таблица комманд

        for(String cmd:p.stringPropertyNames()){
            try {
                Command c=(Command) Proxy.newProxyInstance(Command.class.getClassLoader()
                        ,Class.forName(p.getProperty(cmd).trim()).getInterfaces(), new Handeler());

                guruTable.put(cmd.trim(), (Command)Class.forName(p.getProperty(cmd).trim()).newInstance());

            }
            catch (ClassNotFoundException | InstantiationException |IllegalAccessException e  ){}
        }



        //считывание файла
        start:
        if(args.length>0)
            try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {



                while((s=br.readLine())!=null){
                    try {
                        Parser.parser(s,  guruTable,stack, define);
                    }
                    catch (LowElementInStackException | NegativeNumberException  e){
                        System.out.println(e);
                    }
                    catch (CmdException e){
                        System.out.println(e);
                    }
                    catch (EmptyStackException e){
                        System.out.println("Стек пуст");
                    }
                }

            }
            catch (FileNotFoundException e){
                System.out.println("Файл не найден");
            }
        else{
            Scanner cin=new Scanner(System.in);
            for(;;){
                s=cin.nextLine();
                if (s.trim().toLowerCase().equals("end")){
                    System.out.println("Пока)");
                    break start;
                }
                try {
                    Parser.parser(s,  guruTable,stack, define);
                }
                catch (LowElementInStackException | NegativeNumberException  e){
                    System.out.println(e);
                }
                catch (CmdException e){
                    System.out.println(e);
                }
                catch (EmptyStackException e){
                    System.out.println("Стек пуст");
                }
            }


        }

    }
}
