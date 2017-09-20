package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(), fileName2 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(fileName1);
        byte[] buffer1 = new byte[fis1.available()];
        if (fis1.available() > 0) {
            fis1.read(buffer1);
        }
        FileOutputStream fos1 = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        byte[] buffer2 = new byte[fis2.available()];
        byte[] buffer3 = new byte[buffer1.length + buffer2.length];

        if (fis2.available() > 0) {
            fis2.read(buffer2);
        }

        int tmp = 0;
        for (int i = tmp; i < buffer2.length; i++) {
            buffer3[i] = buffer2[i];
            if (buffer2.length - 1 == i) tmp = buffer2.length;
        }
        for (int i = tmp; i < buffer1.length + tmp; i++) {
            buffer3[i] = buffer1[i - tmp];
        }

        fos1.write(buffer3);

        fis1.close();
        fos1.close();
        fis2.close();
    }
}
