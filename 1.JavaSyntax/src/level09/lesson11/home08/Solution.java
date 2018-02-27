package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.*/
public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }
    public static ArrayList<int[]> createList()
    {
        int[] ints1 = new int[]{2,5,4,5,8};
        int[] ints2 = new int[]{2,5};
        int[] ints3 = new int[]{2,5,4,5};
        int[] ints4 = new int[]{2,5,4,5,8,8,7};
        int[] ints5 = new int[]{};
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(ints1);
        arrayList.add(ints2);
        arrayList.add(ints3);
        arrayList.add(ints4);
        arrayList.add(ints5);
        return arrayList;
    }
    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
