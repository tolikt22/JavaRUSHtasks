package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.HashSet;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileBuffReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        Set<String> set = new HashSet<>();
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
        Double max = 0.0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                set.clear();
                set.add(entry.getKey());
            } else if (entry.getValue().equals(max)) {
                set.add(entry.getKey());
            }
        }
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
