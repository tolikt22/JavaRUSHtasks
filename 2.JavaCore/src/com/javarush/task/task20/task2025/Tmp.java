package com.javarush.task.task20.task2025;

public class Tmp {
    public static void main(String[] args) {
        int num = 365;
        while (num > 0) {
            System.out.print(num % 10);
            num /= 10;
        }
    }
}
