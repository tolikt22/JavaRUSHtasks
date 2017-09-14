package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            FileInputStream fis = new FileInputStream(fileName);
            int size = fis.available();
            fis.close();
            reader.close();

            if (size < 1000)
                throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}