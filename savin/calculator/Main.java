package com.savin.calculator;

/**
 * СТЕКОВЫЙ КАЛЬКУЯТОР
 */
import java.io.*;
import java.util.*;
import com.savin.commands.*;
public class Main {
    static public void  main(String args[]) throws  IOException{
        //Таблица комманд
        Map<String,Command> guruTable=new HashMap<String, Command>();
        guruTable.put("*",new MultCmd());
        guruTable.put("/",new DevCmd());
        guruTable.put("+",new AddCmd());
        guruTable.put("-",new MinusCmd());
        guruTable.put("sqrt".toLowerCase().trim(),new SqrtCmd());
        guruTable.put("define".toLowerCase().trim(),new DefineCmd());
        guruTable.put("push".trim().toLowerCase(),new PushCmd());
        guruTable.put("pop".toLowerCase().trim(),new PopCmd());
        guruTable.put("print".trim().toLowerCase(),new PrintCmd());
        //считывание файла
        try {

            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String s;
            Stack<Double> stack =new Stack<Double>();
            Map<String,Double> define=new HashMap<String, Double>();

            while((s=br.readLine())!=null){
                try {
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
            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }
}
