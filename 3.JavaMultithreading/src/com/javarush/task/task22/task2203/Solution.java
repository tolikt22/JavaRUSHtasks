package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty() || !string.contains("\t")) throw new TooShortStringException();

        int tabCount = 0;
        Pattern pattern = Pattern.compile("\t");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) tabCount++;
        if (tabCount< 2) throw new TooShortStringException();

        String forPrn = "";
        String[] strings = string.split("\t");
        for (int i = 1; i < 2; i++) {
            forPrn += strings[i];
        }
        return forPrn;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
