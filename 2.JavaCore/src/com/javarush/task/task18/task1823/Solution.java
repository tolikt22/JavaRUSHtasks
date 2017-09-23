package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        FileInputStream fis;

        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
            fis = new FileInputStream(this.fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                List<Integer> bytes = new ArrayList<>();
                while (fis.available() > 0) bytes.add(fis.read());
//                System.out.println(Arrays.toString(bytes.toArray()));
                findMaxByte(bytes);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void findMaxByte(List<Integer> bytes) {
            int tmp, count = 0, maxRepeat = 0, maxByte = 0;
            for (int i = 0; i < bytes.size(); i++) {
                tmp = bytes.get(i);
                for (int j = 0; j < bytes.size(); j++) {
                    if (tmp == bytes.get(j)) count++;
                }
                if (maxRepeat < count) {
                    maxRepeat = count;
                    maxByte = tmp;
                }
                count = 0;
            }
            synchronized (resultMap) {
                resultMap.put(this.fileName, maxByte);
                System.out.println(maxByte);
            }
//            System.out.println(Arrays.toString(resultMap.entrySet().toArray()));

//            for (Map.Entry<String,Integer> pair : resultMap.entrySet()){
//                System.out.println(pair.getKey());
//            }
        }
    }
}
