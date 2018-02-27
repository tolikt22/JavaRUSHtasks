package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/
public class SolutionSEX1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        //сортировка чисел (String - int - sort - Srting), (без смены ячейки)
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                int a = Integer.parseInt(array[i]);
                for (int j = i + 1; j < array.length; j++) {
                    if (isNumber(array[j])) {
                        int b = Integer.parseInt(array[j]);
                        if (a < b) {
                            int min = a;
                            a = b;
                            b = min;
//                            array[i] = a + ""; //сам придумав :-))
//                            array[j] = b + "";
                            array[i] = String.valueOf(a); // а так правильно
                            array[j] = String.valueOf(b);
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }

        //сортировка строк (без смены ячейки)
        for (int i = 0; i < array.length; i++) {
            if (!isNumber(array[i])) {
                String a = array[i];
                for (int j = i + 1; j < array.length; j++) {
                    if (!isNumber(array[j])) {
                        String b = array[j];
                        if (isGreaterThan(a, b)) {
                            String max = a;
                            a = b;
                            b = max;
                            array[i] = a;
                            array[j] = b;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }
    }
    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
