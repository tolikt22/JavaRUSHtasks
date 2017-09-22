package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = reader.readLine(), fileName2 = reader.readLine();
        BufferedReader fileIn = new BufferedReader(new FileReader(new File("d:/file")));
        String s;
        StringBuilder sb = null;
        while ((s = fileIn.readLine()) != null) {
            sb.append(s);
        }
        s = sb.toString();
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(s));
        Arrays.toString(list.toArray());
    }
}