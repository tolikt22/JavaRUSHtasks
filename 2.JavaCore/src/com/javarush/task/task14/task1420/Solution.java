package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x, y;
        x = getNormalInt(reader.readLine());
        y = getNormalInt(reader.readLine());
        if ((x > 0) && (y > 0)) {
//            System.out.println("Наибольшим общим делителем чисел " + x + " и " + y + " является число " + findNOD(x, y));
            System.out.println(findNOD(x, y));
        }
    }

    private static int getNormalInt(String s) throws Exception {
        int x = Integer.parseInt(s);
        if (x > 0 && x % 1 == 0) {
            return x;
        } else throw new Exception();  // условие 2
//            return -1;
    }

    private static int findNOD(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
//            System.out.println(tmp);
            a = b;
            b = tmp;
        }
        return a;
    }
}
