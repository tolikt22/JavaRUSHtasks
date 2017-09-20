package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        float countAll = 0, countSpaces = 0;
        while (fis.available() > 0) {
            countAll++;
            if (fis.read() == 32) countSpaces++;
//            Pattern pattern = Pattern.compile("[/s]");
//            Matcher matcher = pattern.matcher(Character.toString((char) fis.read()));
//            countSpaces += matcher.matches() ? 1 : 0;
        }
        fis.close();

//        System.out.println(countSpaces);
//        System.out.println(countAll);
        float result = (countSpaces / countAll) * 100;
//        System.out.println(result);
        System.out.format("%.2f", result);
    }
}