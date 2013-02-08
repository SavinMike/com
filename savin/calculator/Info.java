package com.savin.calculator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: acer
 * Date: 06.02.13
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */
public class Info  {


    public static Properties getProperties(){

        try(InputStream in =Info.class.getResourceAsStream("cmd.config")){

            Properties p =new Properties();
            p.load(in);
            return p;
        }
        catch (IOException e){
            return null;
        }

    }
}
