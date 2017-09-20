package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(),
                fileName2 = reader.readLine(),
                fileName3 = reader.readLine();
        FileOutputStream fos1 = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        FileInputStream fis3 = new FileInputStream(fileName3);

        if (fis2.available()>0){
            byte[] buffer = new byte[fis2.available()];
            fis2.read(buffer);
            fos1.write(buffer);
        }
        if (fis3.available()>0){
            byte[] buffer = new byte[fis3.available()];
            fis3.read(buffer);
            fos1.write(buffer);
        }
        fos1.close();
        fis2.close();
        fis3.close();


    }
}
