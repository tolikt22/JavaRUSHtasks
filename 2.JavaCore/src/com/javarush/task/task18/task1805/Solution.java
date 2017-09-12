package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Сортировка байт
*/
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        List<Integer> bytes = new ArrayList<>();


        while (fis.available() > 0) {
            bytes.add(fis.read());
        }
        reader.close();
        fis.close();

//        for (Integer i : bytes) {
//            System.out.print(i + " ");
//        }
//        System.out.println();



//        Collections.sort(bytes);
//        for (int i = 0; i < bytes.size(); i++) {
//            int repeat = Collections.frequency(bytes, bytes.get(i));
//            if (repeat > 1) bytes.remove(i);
//        }


//        Integer original, count;
//        for (int i = 0; i < bytes.size(); i++) {
//            original = bytes.get(i);
//            count = 0;
//            for (int j = 0; j < bytes.size(); j++) {
//                if (bytes.get(j).equals(original)) {
//                    bytes.remove(j);
//                    count++;
//                }
//            }
//// If we have deleted only one from byte, paste it back
//            if (count == 1) {
//                bytes.add(i, original);
//            }
//        }

        Set treeSet = new TreeSet();
        for (int i = 0; i < bytes.size(); i++) {
            treeSet.add(bytes.get(i));
        }
        for (Object i : treeSet) {
            System.out.print(i + " ");
        }
    }
}
