package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    ; //add your code here - добавьте код тут


    public static Flyable result;

    public static void reset()  {
        //add your code here - добавьте код тут
        try {
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            String s=reader.readLine();
            if(s.equals("helicopter")){
                result=new Helicopter();
            }
            if (s.equals("plane")){
                int y =Integer.parseInt(reader.readLine());
                result=new Plane(y);
            }
        }catch (IOException e){

        }
    }
}