package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileBuffReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        String s[];
        while (fileBuffReader.ready()) {
            s = fileBuffReader.readLine().split(" ");
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getKey().equals(s[0])) {
                    Double d = entry.getValue() + Double.parseDouble(s[1]);
                    entry.setValue(d);
                }
            }
            if (!map.containsKey(s[0])) {
                map.put(s[0], Double.parseDouble(s[1]));
            }
        }
        fileBuffReader.close();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
