package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
        try {
            double d = 7;
        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        try {
            int[] ints = new int[3];
            ints[3] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            String s = "a;lskfjd";
            Integer i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            int[] ints = new int[-3];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
        try {
            Object o = 4;
            String s = (String) o;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        FileReader fr = null;
        try {
            fr = new FileReader("E://file.txt");
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        char[] a = new char[50];
        try {
            try {
                fr.read(a);
            } catch (NullPointerException e) {
                exceptions.add(e);
            }
        } catch (IOException e) {
            exceptions.add(e);
        }

        String str = "Java Code Geeks!";
        System.out.println("Length: " + str.length());
        try {
            char ch = str.charAt(50);
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            getAreaValue(-3,-4);
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }
        try {
            Object[] s = new Integer[4];
            s[0] = 4.4;
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }


    }

    private static int getAreaValue(int x, int y) {
        if(x < 0 || y < 0) throw new IllegalArgumentException("value of 'x' or 'y' is negative: x="+x+", y="+y);
        return x*y;
    }
}
