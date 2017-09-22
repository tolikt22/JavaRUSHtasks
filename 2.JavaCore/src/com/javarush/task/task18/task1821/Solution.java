package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (fis.available() > 0) {
            int key = fis.read();
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
            //map.get(key) возвращает value (в т.ч. может быть null)
        }
        fis.close();

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int c = m.getKey();
            System.out.println((char) c + " " + m.getValue());
        }
    }
}
