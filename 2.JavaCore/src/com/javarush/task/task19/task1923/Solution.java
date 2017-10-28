package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffFileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter buffFileWriter = new BufferedWriter(new FileWriter(args[1]));
        String[] strings;
        char[] chars;
        while (buffFileReader.ready()) {
            strings = buffFileReader.readLine().split(" ");
            for (int i = 0; i < strings.length; i++) {
                chars = strings[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (String.valueOf(chars[j]).matches("^-?\\d+$")) {
                        buffFileWriter.write(strings[i] + " ");
                        buffFileWriter.newLine();
                        break;
                    }
                }
            }
        }
        buffFileReader.close();
        buffFileWriter.close();
    }
}