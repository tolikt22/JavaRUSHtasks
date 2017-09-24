package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        FileInputStream fis;

        for (;true; ) {
            file = reader.readLine();
            try {
                fis = new FileInputStream(file);
                fis.close();
            } catch (FileNotFoundException fne) {
                System.out.println(file);
                break;
            }
        }

    }
}
