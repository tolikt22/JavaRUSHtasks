package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufFileReader = new BufferedReader(new FileReader(reader.readLine()));

        String s;
        while ((s = bufFileReader.readLine()) != null){
            if (s.startsWith(args[0])){
                System.out.println(s);
                break;
            }
        }
        reader.close();
        bufFileReader.close();
    }
}
