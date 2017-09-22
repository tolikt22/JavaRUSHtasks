package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine(), f2 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(f1);
        FileOutputStream fos2 = new FileOutputStream(f2);
        List<Integer> integers = new ArrayList<>();

        byte [] buffer = new byte[fis1.available()];
        if (fis1.available() > 0){
            fis1.read(buffer);
        }
        String s = new String(buffer);
        for(String st : s.split(" ")){
            double d = Double.parseDouble(st);
            integers.add((int) Math.round(d));
        }
        for (Integer i : integers){
            fos2.write((i+" ").getBytes());
        }
        fis1.close();
        fos2.close();
    }
}