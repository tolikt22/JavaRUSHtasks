package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getTokens(" a;kfjaa;sljkf ;asf ;slfj;s f;lskjdf s;dfkljs ;slfjs fasd"," "));
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        List<String> ss = new ArrayList<>();
        while (tokenizer.hasMoreElements()){
            ss.add(tokenizer.nextToken());
        }
        String[] strings = ss.toArray(new String[0]);
        return strings;
    }
}
