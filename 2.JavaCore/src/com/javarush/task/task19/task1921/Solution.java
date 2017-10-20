package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Хуан Хуанович
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader buffFileReader = new BufferedReader(new FileReader(args[0]));
        String[] strings;
        String name;
        Date birthday;
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");

        while (buffFileReader.ready()) {
            strings = buffFileReader.readLine().split(" ");
            StringBuilder sbName = new StringBuilder();
            StringBuilder sbDate = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                if (!isNumber(strings[i])) {
                    sbName.append(strings[i] + " ");
                } else if (isNumber(strings[i])) {
                    String str = (strings[i].length() < 2) ? "0" + strings[i] : strings[i];
                    sbDate.append(str);
                } else System.out.println("Нихуя не получилось.");
            }
            name = sbName.toString().trim();
            birthday = dateFormat.parse(sbDate.toString());
            PEOPLE.add(new Person(name, birthday));
        }
        buffFileReader.close();
//        System.out.println(Arrays.toString(PEOPLE.toArray()));
    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}