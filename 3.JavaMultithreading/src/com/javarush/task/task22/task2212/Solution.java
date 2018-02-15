package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean result = false;

        if (telNumber == null) return false;
        if (telNumber.matches("^\\+\\d{12}")) return true;
        if (telNumber.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}")) return true;
        if (telNumber.matches("^\\+\\d{8}-\\d{2}-\\d{2}")) return true;
        if (telNumber.matches("^\\d{6}-\\d{4}")) return true;
        return false;
    }

    public static void main(String[] args) {
        String[] s = {
                "",
                "+380501234567",
                "+38(050)1234567",
                "+38050123-45-67",
                "050123-4567",
                "+38)050(1234567",
                "+38(050)1-23-45-6-7",
                "050ххх4567",
                "0501236",
                "(0)501234567",
                "+38(050)1-23-45--6-7",
                "+3-8(050)1-23-45--6-7",
                "+38050123-4567-"
        };

        for (String t : s) System.out.printf("%25s :   %5s %n", t, checkTelNumber(t));
    }
}