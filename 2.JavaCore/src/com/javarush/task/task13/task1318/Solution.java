package com.javarush.task.task13.task1318;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
        fileInputStream.close();
        bufferedReader.close();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
//        while (scanner.hasNext()) {
//            String data = scanner.next();
//            System.out.print(data);
//        }

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader inStream = new BufferedReader(new FileReader(reader.readLine()));
//        FileInputStream fis = new FileInputStream(reader.readLine());
//        String str;
//        while ((str = inStream.readLine()) != null) {
//            System.out.println(str);
//        }

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        InputStream fis = new FileInputStream(reader.readLine());
//        while (fis.available() > 0) {
//            System.out.print((char) fis.read());
//        }

//        byte[] buffer = new byte[fis.available()];
//        fis.read(buffer, 0, fis.available());
//        for (int i = 0; i < buffer.length; i++) {
//            System.out.print((char) buffer[i]);
//        }

//        fis.close();
//        inStream.close();
//        reader.close();
    }
}