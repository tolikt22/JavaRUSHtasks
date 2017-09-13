package com.javarush.task.task18.task1808;

import java.io.*;

/*
Разделение файла
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1, f2, f3;
        f1 = reader.readLine();
        f2 = reader.readLine();
        f3 = reader.readLine();

        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos2 = new FileOutputStream(f2);
        FileOutputStream fos3 = new FileOutputStream(f3);
        if (fis.available() > 0) {
            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            fos2.write(buffer, 0, count / 2 + count % 2);
            fos3.write(buffer, count / 2 + count % 2, count / 2);
        }
        fis.close();
        fos2.close();
        fos3.close();
    }
}
