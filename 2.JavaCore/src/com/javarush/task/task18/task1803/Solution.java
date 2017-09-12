package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        int tmp, tmpJ, currentRepeat = 0, maxRepeat = 0;
        List<Integer> bytes = new ArrayList<>();
        Map<Integer, Integer> repeatMap = new HashMap<>();

        while (fis.available() > 0) {
            tmp = fis.read();
            bytes.add(tmp);
        }
        fis.close();
        Collections.sort(bytes);

        for (int j = 0; j < bytes.size(); j++) {
            tmpJ = bytes.get(j);
            for (int i = 0; i < bytes.size(); i++) {
                if (tmpJ == bytes.get(i)) currentRepeat++;
            }
            if (maxRepeat < currentRepeat) {
                repeatMap.clear();
                maxRepeat = currentRepeat;
                repeatMap.put(tmpJ, maxRepeat);
            } else if (maxRepeat == currentRepeat) {
                repeatMap.put(tmpJ, maxRepeat);
            }
            for (int i = 0; i < bytes.size(); i++) {
                if (tmpJ == bytes.get(i)) {
                    bytes.remove(i);
                }
            }
            j = 0;
            currentRepeat = 0;
        }
        Iterator<Map.Entry<Integer, Integer>> entries = repeatMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.print(entry.getKey() + " ");
        }
    }
}
