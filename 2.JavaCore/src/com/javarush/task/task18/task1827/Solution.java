package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(), parameter = null, productName = null, price = null, quantity = null;

        if (args.length != 0 && args[0].equals("-c")) {
            productName = args[1];
            price = args[2];
            quantity = args[3];
            int newID = findMaxId(fileName) + 1;
            addRow(fileName, newID, productName, price, quantity);
        }
    }

    private static int findMaxId(String fileName) throws IOException {
        int maxId = 0, tmp;
        List<String> list;
        Stream<String> stream = Files.lines(Paths.get(fileName));             //in Java 8 !!!
        list = stream.collect(Collectors.toList());
        for (String s : list) {
//            String id = s.substring(0, 8).replaceAll("[\\s]{2,}", "");
            String id = s.substring(0, 8).trim();
            if (maxId < (tmp = Integer.parseInt(id))) maxId = tmp;
        }
        stream.close();
        return maxId;
    }

    private static void addRow(String fileName, int newID, String productName, String price, String quantity) throws IOException {
        String strToAdd = "\n" + String.format("%-8s", newID) + String.format("%-30s", productName)
                + String.format("%-8s", price) + String.format("%-4s",quantity);
        FileWriter writer = new FileWriter(fileName, true);
        BufferedWriter buffWriter = new BufferedWriter(writer);
        buffWriter.write(strToAdd);
        buffWriter.close();
    }
}
