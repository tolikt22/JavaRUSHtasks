package com.javarush.task.task18.task1809;
/*
Реверс файла
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1, f2;
        f1 = reader.readLine();
        f2 = reader.readLine();
        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);

        if (fis.available() > 0) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            for (int i = 0; i < buffer.length / 2; i++) {                   //реверс массива
                byte temp = buffer[i];
                buffer[i] = buffer[buffer.length - 1 - i];
                buffer[buffer.length - 1 - i] = temp;
            }
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
