package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 5");
    }

    public static int getRectangleCount(byte[][] a) {
        int rectangle = 0;
        for (int i = 0; i < a.length - 1; i++) {                // поиск не ставая на крайние правые и нижние ячейки
            for (int j = 0; j < a[0].length - 1; j++) {
                if (a[i][j] == 1 && a[i + 1][j] != 1 && a[i][j + 1] != 1) rectangle++;
            }
        }
        for (int i = 0; i < a[a.length - 1].length - 1; i++) {   // поиск по нижнему краю (нижний ряд)
            if (a[a.length - 1][i + 1] != 1 && a[a.length - 1][i] == 1) rectangle++;
        }
        for (int i = 0; i < a.length - 1; i++) {                 // поиск по правому краю
            if (a[i + 1][a[a.length - 1].length - 1] != 1 && a[i][a[a.length - 1].length - 1] == 1) rectangle++;
        }                                                        // проверка правой нижней ячейки (правая колонка)
        if (a[a[a.length - 1].length - 1][a.length - 1] == 1) rectangle++;
        return rectangle;
    }
}
