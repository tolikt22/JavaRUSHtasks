package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        String res = "";
        ArrayList<Integer> bytes = new ArrayList<Integer>();
        ArrayList<Integer> bytesResult = new ArrayList<Integer>();

        while (fis.available() > 0) bytes.add(fis.read());
        reader.close();
        fis.close();

//в count считаем кол-во каждого байта
        int[] count = new int[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            count[i] = 0;
            for (int j = 0; j < bytes.size(); j++) {
                if (bytes.get(i).equals(bytes.get(j))) count[i]++;
            }
        }
//находим в count минимум повтора
        int min = Integer.MAX_VALUE;
        for (int h : count) {
            if (h < min) min = h;
        }
//собираем байты с минимумом использования и без повторов
//если в bytesResult еще нет такого байта из bytes с соотв. min в паралельном списке count[] , то добавляем такой байт
        for (int i = 0; i < bytes.size(); i++) {
            if (!bytesResult.contains(bytes.get(i)) && count[i] == min) bytesResult.add(bytes.get(i));
        }
        for (int y : bytesResult) {
            res += y + " ";
        }
        System.out.println(res);
    }
}