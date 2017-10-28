package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buffFileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String[] strings;
        String s;
        int counter = 0;
        while (buffFileReader.ready()) {
            s = buffFileReader.readLine();
            strings = s.split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (words.contains(strings[i])) counter++;
            }
            if (counter == 2) System.out.println(s);
            counter = 0;
        }
        buffFileReader.close();
    }
}
