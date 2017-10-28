package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bFR = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String s;
        while ((s = bFR.readLine()) != null) {
            char[] chars = s.toCharArray();
            char tmp;
            for (int i = 0; i < chars.length / 2; i++) {
                tmp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = tmp;
            }
            String newS = new String(chars);
            System.out.println(newS);
        }
        bFR.close();
    }
}
