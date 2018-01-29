package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        //...
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        while ((line = readerFromFile.readLine()) != null) stringBuilder.append(line);

        StringBuilder result = getLine(stringBuilder.toString().split("\\s"));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> strings = new ArrayList<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();
        if (strings.isEmpty())return sb;

        sb.append(strings.get(0));
        strings.remove(0);

        while (!strings.isEmpty()) {
            for (int i = 0; i < strings.size(); i++) {
                String a = strings.get(i).toUpperCase();
                String b = sb.toString().toUpperCase();
                if (a.charAt(0) == b.charAt(sb.length() - 1))
                {
                    sb.append(" ").append(strings.get(i));
                    strings.remove(i);
                    continue;
                }

                if (b.charAt(0) == a.charAt(a.length() - 1))
                {    String tmpStr = strings.get(i) + " " + sb;
                    sb.delete(0,sb.length());
                    sb.append(tmpStr);
                    strings.remove(i);
                }
            }
        }
        return sb;
    }
}
