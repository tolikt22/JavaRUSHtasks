package com.javarush.task.task19.task1918;
/*
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        StringBuilder sb = new StringBuilder();
        while (bufferedFileReader.ready()) sb.append(bufferedFileReader.readLine());
        String s = sb.toString().replaceAll("\r\n", "");
        bufferedFileReader.close();

        String open = ("<" + args[0]), close = ("</" + args[0] + '>');
        String[] listOp = new String[s.length()];
        String[] listCl = new String[s.length()];
        Map<Integer, String> map = new TreeMap<>();

        int idxOpen, idxClose;
        for (int i = 0; i < s.length(); i = idxOpen + 1) {
            idxOpen = s.indexOf(open, i);
            if (idxOpen != -1) {
                listOp[idxOpen] = "open";
            } else break;
        }
        for (int i = 0; i < s.length(); i = idxClose + 1) {
            idxClose = s.indexOf(close, i);
            if (idxClose != -1) {
                listCl[idxClose] = "close";
            } else break;
        }
        for (int i = 0; i < listCl.length; i++) {
            if (listCl[i] != null && listCl[i].equals("close")) {
                for (int j = i; j >= 0; j--) {
                    if (listOp[j] != null && listOp[j].equals("open")) {
                        map.put(j, s.substring(j, i + close.length()));
                        listOp[j] = null;
                        listCl[i] = null;
                        i = 0;
                        j = 0;
                    }
                }
            }
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

