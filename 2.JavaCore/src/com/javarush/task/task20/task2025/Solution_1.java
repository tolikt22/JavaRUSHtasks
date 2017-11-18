package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 {
    public static int[] getNumbers(int N) {
        int[] result = null;
        List<Integer> result_list = new ArrayList<>(); //список, куда складываются подходящие числа

        for (int i = 1; i < N; i++) {
            List<Integer> digits = new ArrayList<>(); //список, куда складываются символы числа(к примеру: 453 - в список войдут 4,5,3)

            int num = i;
            while (num > 0) //заполнение списка digits числами
            {
                digits.add(num % 10);
                num /= 10;
            }
            int m = digits.size(); //установка степени
            long sum = 0; //тут будет итоговая сумма степеней цифр
            for (int in : digits) //для каждого значения из списка digits
            {
                int counter = 1; //счетчик проходов для умножения
                int temp = in;
                while (counter < m) //пока счетчик меньше множителя, умножаем цифру
                {
                    temp *= in;
                    ++counter;
                }
                sum += temp; //плюсуем к сумме результат умножения числа
            }
            if (sum == i) {
                result_list.add(i); //если сумма цифр эквивалентна числу - добавляем в список результатов
                System.out.println(i);
            } //для проверки добавляемых чисел. Валидатор пропускает.
        }
        result = new int[result_list.size()]; //устанавливаем размер массива result по размеру списка
        for (int q = 0; q < result_list.size(); q++) //добавляем объекты списка в массив
        {
            result[q] = result_list.get(q);
        }

        return result;
    }

    public static void main(String[] args) { //для проверки. Пропускается валидатором
        Long t0 = System.currentTimeMillis();
        int n = Integer.MAX_VALUE;
        int[] numbers = getNumbers(24678052);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));
    }
}
