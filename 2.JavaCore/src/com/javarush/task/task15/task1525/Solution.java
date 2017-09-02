package com.javarush.task.task15.task1525;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

//    static {
//        String line;
//        try {
//            FileInputStream fis = new FileInputStream(Statics.FILE_NAME);
//            BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(fis));
//            while ((line = readerFromFile.readLine()) != null){
//                lines.add(line);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static {                         // Этот блок заменяет верхний в Java 8
    try {
        lines = Files.readAllLines(Paths.get(Statics.FILE_NAME));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
