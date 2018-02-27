package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String oldDateString = reader.readLine();
//        DateFormat oldDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//        DateFormat newDateFormat = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
//        Date date = oldDateFormat.parse(oldDateString);
//        String result = newDateFormat.format(date);
//        System.out.println(result.toUpperCase());

        LocalDate date = LocalDate.parse(oldDateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));//java.time (Java 8)
        String result = date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy", new Locale("en")));
        System.out.println(result.toUpperCase());
    }
}


