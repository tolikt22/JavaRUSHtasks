package com.javarush.task.task13.task1319;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffreader = new BufferedReader(new InputStreamReader(System.in));
        String filename = buffreader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        String line;
        while (!(line = buffreader.readLine()).equals("exit")) {
            writer.write(line);
            writer.newLine();
        }
        writer.write("exit");
        writer.close();
        buffreader.close();
    }
}
