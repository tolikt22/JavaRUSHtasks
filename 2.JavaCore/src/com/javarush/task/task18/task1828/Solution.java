package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if ("-u".equals(args[0])) {
//            String id = padRight(args[1], 8);
            String id = String.format("%1$-" + args[1] + "s", 8);
//            String newProductName = padRight(args[2], 30);
            String newProductName = padRight(args[2], 30);
            String price = padRight(args[3], 8);
            String newQuantity = padRight(args[4], 4);

            List<StringBuilder> fileLines = readFileLines(fileName);
            for (StringBuilder line : fileLines) {
                if (id.equals(line.substring(0, 8))) {
                    line.setLength(0); // clear string
                    line.append(id + newProductName + price + newQuantity);
                    break;
                }
            }
            writeFile(fileName, fileLines);

        }
        else if ("-d".equals(args[0])) {
            String id = padRight(args[1], 8);

            List<StringBuilder> fileLines = readFileLines(fileName);
            Iterator<StringBuilder> iter = fileLines.iterator();
            while (iter.hasNext()) {
                if (id.equals(iter.next().substring(0, 8))) {
                    iter.remove();
                    break;
                }
            }
            writeFile(fileName, fileLines);
        }
    }

    private static List<StringBuilder> readFileLines(String fileName) throws IOException {
        List<StringBuilder> fileLines = new LinkedList<>();
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str = fReader.readLine()) != null) {
            fileLines.add(new StringBuilder(str));
        }
        fReader.close();
        return fileLines;
    }

    private static void writeFile(String fileName, List<StringBuilder> fileLines) throws IOException {
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName));
        for (StringBuilder line : fileLines) {
            fWriter.write(line.toString());
            fWriter.newLine();
        }
        fWriter.close();
    }

    private static String padRight(String input, int len) {
        if (input.length() < len) {
            return String.format("%1$-" + len + "s", input);
        } else {
            return input.substring(0, len);
        }
    }
}

