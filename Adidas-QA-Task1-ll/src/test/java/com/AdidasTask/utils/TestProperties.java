package com.AdidasTask.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static String base_api="";
    
    static{

        Properties p=new Properties();

        try {
            p.load(new FileInputStream((System.getProperty("user.dir")+"/src/test/resources/config.properties")));
            base_api=p.getProperty("base_api");
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
