package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String s, date;
            String[] strings;
            s = fileScanner.next();
            strings = s.split(" ");
            date = strings[3] + " " + strings[4] + " " + strings[5];
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd MM yyyy");
            Date birthDay = format.parse(date);
            Person person = new Person(strings[0], strings[1], strings[2], birthDay);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
