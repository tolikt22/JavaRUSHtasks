package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(), fileName2 = reader.readLine();
        BufferedReader bufFileReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader bufFileReader2 = new BufferedReader(new FileReader(fileName2));
        String line1, line2;
        int sames = 0, ads = 0, rems = 0;

        while ((bufFileReader1.ready() || bufFileReader2.ready()) && (ads + rems - sames < 1)) {
            line1 = (bufFileReader1.ready()) ? bufFileReader1.readLine() : "";
            line2 = (bufFileReader2.ready()) ? bufFileReader2.readLine() : "";

            if (line1.length() == line2.length()) {
                sames++;
                lines.add(new LineItem(Type.SAME, line1));
            } else if (line1.length() > line2.length()) {
                if (++ads + rems - sames < 1) {
                    lines.add(new LineItem(Type.REMOVED, line1));
                }
            } else if (line1.length() < line2.length()) {
                if (++rems + ads - sames < 1) {
                    lines.add(new LineItem(Type.ADDED, line2));
                }
            }
        }
        reader.close();
        bufFileReader1.close();
        bufFileReader2.close();

//        for (int i = 0; i < lines.size(); i++) {
//            System.out.println(lines.get(i).type + " " + lines.get(i).line);
//        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
