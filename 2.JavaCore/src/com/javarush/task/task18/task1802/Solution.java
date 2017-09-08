package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int minByte = 999999999;
        int tmp;
        while (fis.available() > 0) {
            tmp = fis.read();
            minByte = minByte > tmp ? tmp : minByte;
        }
        reader.close();
        fis.close();
        System.out.println(minByte);
    }
}
