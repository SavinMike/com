package com.savin.calculator;

/**
 * Печать из команд плохо (System.out.println("В стеке нехватает переменных");) Команды должны сообщать калькулятору что произошло а его ответственность верным способом показать нужное сообщение. За исключением команд типа print. Смотрите сколько раз у вас встречается System.out.println("Стек пуст");  и представьте что стоит задача локализации приложения на другой язык (не русский). У вас получается каждая команда зависит от типа интерфейса (консольный или графический) и локализации приложения
 * СТЕКОВЫЙ КАЛЬКУЯТОР
 */
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import com.savin.CalcException.CmdException;
import com.savin.commands.*;
public class Main{



    static public void  main(String args[]) throws  IOException{
        String s="";
        final Stack<Double> stack =new Stack<>();
        final Map<String,Double> define=new HashMap<>();

        //Таблица комманд


        CmdFactory cmdFactory= new CmdFactory(new InitCommands() {
        @Override
        public void init(Command c) {

            for (Field a : c.getClass().getDeclaredFields())  {
                if(a.getAnnotation(In.class).value()==ElementOfAnnotation.STACK){
                    try {
                        a.setAccessible(true);
                        a.set(c,stack);
                    }
                    catch (IllegalAccessException e){System.out.println(e);}


                }
                else if(a.getAnnotation(In.class).value()== ElementOfAnnotation.CONTEXT){
                    try {
                        a.setAccessible(true);
                        a.set(c,define);
                    }
                    catch (IllegalAccessException e){System.out.println(e);}


                }

            }

        }
    });











        //считывание файла
        start:
        if(args.length>0)
            try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {



                while((s=br.readLine())!=null){
                    try {
                        Parser.parser(s,  cmdFactory);
                    }

                    catch (CmdException l){
                        System.out.println(l);
                    }
                    catch (EmptyStackException em){
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
                    Parser.parser(s,  cmdFactory);
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
