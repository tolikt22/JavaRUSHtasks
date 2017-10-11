package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileReader f1Reader = new FileReader(fileName1);
        FileWriter f2Writer = new FileWriter(fileName2);
        BufferedReader bufFileReader = new BufferedReader(f1Reader);
        BufferedWriter bufFileWriter = new BufferedWriter(f2Writer);
        char c;

        while (bufFileReader.ready()) {
            c = (char) bufFileReader.read();
            if (c == '.') c = '!';
            bufFileWriter.write(c);
        }
        bufFileReader.close();
        bufFileWriter.close();

    }
}
