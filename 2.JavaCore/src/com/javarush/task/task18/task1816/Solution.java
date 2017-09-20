package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s);
        }
        reader.close();

        s = sb.toString();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            Pattern p = Pattern.compile("[a-zA-z]");
            Matcher m = p.matcher(Character.toString(c));
            count += m.matches() ? 1 : 0;
        }
        System.out.println(count);
    }
}
