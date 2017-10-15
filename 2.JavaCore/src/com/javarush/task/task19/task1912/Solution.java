package com.javarush.task.task19.task1912;
/*
Ридер обертка 2
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
        String string = baos.toString();

        System.setOut(console);
        System.out.println(string.replaceAll("te" ,"??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
