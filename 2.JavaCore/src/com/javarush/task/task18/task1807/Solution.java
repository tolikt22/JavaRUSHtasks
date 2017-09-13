package com.javarush.task.task18.task1807;
/*
Подсчет запятых
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int count = 0;

        while (fis.available() > 0) {
            int i = fis.read();
            count = (i == 44) ? count += 1 : count;
        }
        fis.close();
        System.out.print(count);
    }
}
