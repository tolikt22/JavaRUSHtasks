package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int maxByte = 0;
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            maxByte = maxByte < tmp ? tmp : maxByte;
        }
        reader.close();
        fileInputStream.close();
        System.out.println(maxByte);
    }
}
