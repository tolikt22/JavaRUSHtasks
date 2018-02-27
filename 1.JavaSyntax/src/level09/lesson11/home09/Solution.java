package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        System.out.println(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String,Cat> catMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            catMap.put("cat" + i, new Cat("Murzabek"+i));
        }
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> catSet = new HashSet<>();
        for (int i = 0; i < map.size()-1; i++) {
            Iterator<Map.Entry<String,Cat>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String,Cat> pair = iterator.next();
//                String key = pair.getKey();
                Cat value = pair.getValue();
                catSet.add(value);
            }
        }
        return catSet;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
