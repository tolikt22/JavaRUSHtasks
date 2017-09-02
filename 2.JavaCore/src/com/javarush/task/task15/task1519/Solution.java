package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Разные методы для разных типов
*/
public class Solution {
    static String s;
    static Double d;
    static Short sh;
    static Integer i;

    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!(s = reader.readLine()).equals("exit")) {
            if (checkInteger(s)) {
                if ((Integer.parseInt(s) > 0) && (Integer.parseInt(s) < 128)) {
                    print((short) Integer.parseInt(s));
                } else {
                    print(Integer.parseInt(s));
                }
            } else if (checkDouble(s)) {
                print(Double.parseDouble(s));
            } else {
                print(s);
            }
        }
    }

    private static boolean checkInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return false;
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
