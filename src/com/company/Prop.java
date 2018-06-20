package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Prop <T> {
    private File file = new File("src\\com\\company\\file.properties");

    //private Properties properties = new Properties();
    private int n;
    private String string2="";

    Map<String, String> propmap = new HashMap<>();

    public void getFile () {
        try (FileReader fileReader = new FileReader(file)) {
            String[] props;
            String string ="";
            BufferedReader br= new BufferedReader(fileReader);
            while ((string = br.readLine()) != null) {
                string2+=string+" ";
            }
            System.out.println(string2);
            props = string2.split("=|\\s");
            for (String prop : props) {
                System.out.println(prop);
            }
            String[] key = new String[props.length/2];
            String[] value = new String[props.length/2];
            n=key.length;

            int j=0;
            for (int i=0; i<key.length;i++) {
                key[i] = props[j];
                j=j+2;
            }

            j = 1;
            for (int i=0; i<value.length;i++) {
                    value[i] = props[j];
                    j=j+2;
            }
            for (int i = 0; i < key.length; i++) {
                propmap.put(key[i], value[i]);
                System.out.println();
                //System.out.println(key[i]);
                //System.out.println(value[i]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getProps () throws NoSuchFieldException {
        Object[] values = new Object[n];
        T value1= (T) propmap.get("value1");
        values[0]=value1;
        T value2= (T) propmap.get("value2");
        values[1]=value2;
        T value3= (T) propmap.get("value3");
        values[2]=value3;
        T value4= (T) propmap.get("value4");
        values[3]=value4;
        T value5= (T) propmap.get("value5");
        values[4]=value5;

        for (int i=0;i<n;i++) {
            if (values[i] != null) {
                System.out.println(values[i]);
                System.out.println();
            } else {
                System.out.println("номер поля " +i);
                throw new NoSuchFieldException("нэт такого поля");
            }
        }


    }

    public void putExistentKey (String a, String b) {
        for(Map.Entry<String, String> item : propmap.entrySet()){

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }
        propmap.put(a, b);
        System.out.println();
        for(Map.Entry<String, String> item : propmap.entrySet()){

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }
    }
}
