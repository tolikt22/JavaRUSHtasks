package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        while (fis.available()>0){
            byte[] buffer = new byte[1000];
            fis.read(buffer);
            String s = new String(buffer,windows1251);
            buffer = s.getBytes(utf8);
            fos.write(buffer);
        }
    }
}
