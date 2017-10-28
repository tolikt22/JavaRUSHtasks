package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;
        BufferedReader bFR = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bFW = new BufferedWriter(new FileWriter(args[1]));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = bFR.readLine()) != null) {
            String[] strings = s.split(" ");
            for (String string : strings) {
                if (string.length() > 6) sb.append(string).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        bFW.write(sb.toString());
        bFR.close();
        bFW.close();
    }
}
