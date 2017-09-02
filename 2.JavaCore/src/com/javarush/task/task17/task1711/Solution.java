package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static String name;
    static Sex sex;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static Date bd;

    static {
        allPeople.add(Person.createMale("Иванов Петр", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Иван", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case ("-c"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        doCreate(args[i], args[i + 1], args[i + 2]);
                    }
                    break;
                }
            case ("-u"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        doUpdate(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                    break;
                }
            }
            case ("-d"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 1) {
                        doDelete(args[i]);
                    }
                    break;
                }
            }
            case ("-i"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 1) {
                        showInfo(args[i]);
                    }
                    break;
                }
            }
        }
    }

    private static void doCreate(String arg1, String arg2, String arg3) throws ParseException {
        name = arg1;
        sex = (arg2.equals("м")) ? Sex.MALE : Sex.FEMALE;
        bd = dateFormat.parse(arg3.toString());
        if (sex == Sex.MALE) {
            allPeople.add(Person.createMale(name, bd));
        } else if (sex == Sex.FEMALE) {
            allPeople.add(Person.createFemale(name, bd));
        }
        System.out.println(allPeople.size() - 1);
    }

    private static void doUpdate(String arg1, String arg2, String arg3, String arg4) throws ParseException {
        name = arg2;
        sex = (arg3.equals("м")) ? Sex.MALE : Sex.FEMALE;
        bd = dateFormat.parse(arg4.toString());
        int id = Integer.parseInt(arg1);
        allPeople.get(id).setName(name);
        allPeople.get(id).setSex(sex);
        allPeople.get(id).setBirthDay(bd);
        System.out.println(allPeople.get(id).toString());
    }

    private static void doDelete(String arg1) {
        int id = Integer.parseInt(arg1);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    private static void showInfo(String arg1) {
        int id = Integer.parseInt(arg1);
        System.out.println(allPeople.get(id).toString());
    }
}

