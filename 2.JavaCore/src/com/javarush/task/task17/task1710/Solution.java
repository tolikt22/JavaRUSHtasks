package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String parameter = args[0];
        String name;
        Sex sex;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date bd;


        if (parameter.equals("-c")) {
            name = args[1];
            sex = (args[2].equals("м")) ? Sex.MALE : Sex.FEMALE;
            bd = dateFormat.parse(args[3].toString());
            if (sex == Sex.MALE) {
                allPeople.add(Person.createMale(name, bd));
            } else if (sex == Sex.FEMALE) {
                allPeople.add(Person.createFemale(name, bd));
            }
            System.out.println(allPeople.size() - 1);
//        for (Person person : allPeople) {
//            System.out.println(person.toString());
//        }
        }
        if (parameter.equals("-u")) {
            name = args[2];
            sex = (args[3].equals("м")) ? Sex.MALE : Sex.FEMALE;
            bd = dateFormat.parse(args[4].toString());
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(sex);
            allPeople.get(id).setBirthDay(bd);
//            System.out.println(allPeople.get(id).toString());
        }
        if (parameter.equals("-d")) {
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
        }
        if (parameter.equals("-i")) {
            int id = Integer.parseInt(args[1]);
            System.out.println(allPeople.get(id).toString());
        }
    }
}
