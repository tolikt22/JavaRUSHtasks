package com.javarush.task.task13.task1326;
/*
Сортировка четных чисел из файла
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(fis));
        String line;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        while ((line = readerFromFile.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }

        readerFromFile.close();
        reader.close();
        fis.close();

        //separateOdds
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                odds.add(numbers.get(i));
            }
        }

        //bubbleSort_
        int min;
        for (int y = odds.size() - 1; y >= 0; y--) {
            for (int i = 0; i < y; i++) {
                if (odds.get(i) > odds.get(i + 1)) {
                    min = odds.get(i);
                    odds.set(i, odds.get(i + 1));
                    odds.set(i + 1, min);
                }
            }
        }
        System.out.println(Arrays.toString(odds.toArray()));
    }
}
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
//        try {
//            TreeSet<Integer> set = new TreeSet<>();
//            int num;
//            String line;
//            while ((line = file.readLine()) != null) {
//                num = Integer.parseInt(line);
//                if (num % 2 == 0) {
//                    set.add(num);
//                }
//            }
//            for (int i : set) {
//                System.out.println(i);
//            }
//            reader.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("Error: " + e);
//        } finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//                if (file != null) {
//                    file.close();
//                }
//            } catch (IOException e) {
//            }
//        }
//    }
//}
