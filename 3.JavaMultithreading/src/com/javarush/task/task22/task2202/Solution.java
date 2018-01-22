package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String[] strings = string.split(" ");
        String forPrint = "";
        if (strings.length < 5) throw new TooShortStringException();
        for (int i = 1; i < 5; i++) {
            forPrint += strings[i] + " ";
        }
        return forPrint.trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
