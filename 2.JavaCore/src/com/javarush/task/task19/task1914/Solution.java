package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);

        String[] s = baos.toString().split(" ");

        int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[2]);
        if (s[1].equals("+")) {
            System.out.println(x + " + " + y + " = " + (x + y));
        } else if (s[1].equals("-")) {
            System.out.println(x + " - " + y + " = " + (x - y));
        } else {
            System.out.println(x + " * " + y + " = " + (x * y));

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

