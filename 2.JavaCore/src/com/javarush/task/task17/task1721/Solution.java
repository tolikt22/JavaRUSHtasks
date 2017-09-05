package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String fistFileName, secondFileName;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fistFileName = reader.readLine();
            secondFileName = reader.readLine();
            String s;

            BufferedReader buffFileReader1 = new BufferedReader(new FileReader(fistFileName));
            while ((s = buffFileReader1.readLine()) != null) {
                allLines.add(s);
            }
            BufferedReader buffFileReader2 = new BufferedReader(new FileReader(secondFileName));
            while ((s = buffFileReader2.readLine()) != null) {
                forRemoveLines.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        //allLines = Files.readAllLines(Paths.get(reader.readLine()),StandardCharsets.UTF_8);
        //reader.lines().forEach(allLines::add);
//        for (String string : allLines) {
//            System.out.println(string);
//        }


    }


    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
