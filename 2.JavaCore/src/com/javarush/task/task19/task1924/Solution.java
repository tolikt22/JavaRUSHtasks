package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buffFileReader = new BufferedReader(new FileReader(reader.readLine()));

        while (buffFileReader.ready()) {
            list.add(buffFileReader.readLine());
        }
        reader.close();
        buffFileReader.close();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches(".*\\b((1[012])|[0-9])\\b.*")) {
                String[] strings = list.get(i).split(" ");
                String newLine = "";
                for (String word : strings) {
                    if (word.matches("((1[012])|[0-9])")) {
                        newLine = newLine + map.get(Integer.parseInt(word)) + " ";
                    } else {
                        newLine = newLine + word + " ";
                    }
                }

                newLine.trim();
                list.remove(i);
                list.add(i, newLine);
            }
        }

        for (String lines : list) {
            System.out.println(lines);
        }
    }

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
}
