package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Petrov1", "Ivan");
        map.put("Petrov2", "Pedro");
        map.put("Petrov3", "Vasyl");
        map.put("Petrov4", "Alesha");
        map.put("Petrov5", "Miho");
        map.put("Petrov6", "Sydir");
        map.put("Petrov7", "Ivasyk");
        map.put("Petrov8", "Drunya");
        map.put("Petrov9", "Sydir");
        map.put("Petrov10", "Sydir");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) if (pair.getValue().equals(name)) count++;
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) if (pair.getKey().equals(lastName)) count++;
        return count;
    }

    public static void main(String[] args) {
        createMap();
//        getCountTheSameFirstName(createMap(),"Гречка");
//        getCountTheSameLastName(createMap(),"Івась");
        System.out.println(getCountTheSameFirstName(createMap(), "Sydir") + " : "
                + getCountTheSameLastName(createMap(), "Petrov3"));

    }
}
