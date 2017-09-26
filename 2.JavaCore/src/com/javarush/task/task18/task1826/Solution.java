package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String parameter = args[0], fileName = args[1], fileOutputName = args[2];
        if (parameter.equals("-e")) encodeFile(fileName, fileOutputName);
        if (parameter.equals("-d")) decodeFile(fileName, fileOutputName);
    }

    private static void encodeFile(String fileName, String fileOutputName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        while (fis.available() > 0) {
            fos.write(fis.read() << 1);
        }
        fis.close();
        fos.close();
    }

    private static void decodeFile(String fileName, String fileOutputName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        while (fis.available() > 0) {
            fos.write(fis.read() >> 1);
        }
        fis.close();
        fos.close();
    }
}
