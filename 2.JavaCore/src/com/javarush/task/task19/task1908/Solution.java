package com.javarush.task.task19.task1908;
import java.io.*;

/*Выделяем числа
        Считать с консоли 2 имени файла.
        Вывести во второй файл все числа, которые есть в первом файле.
        Числа выводить через пробел.
        Закрыть потоки.

        Пример тела файла:
        12 text var2 14 8v 1

        Результат:
        12 14 1

        Требования:
        1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
        2. BufferedReader для считывания данных с консоли должен быть закрыт.
        3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
        4. Поток чтения из файла (BufferedReader) должен быть закрыт.
        5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
        6. Поток записи в файл (BufferedWriter) должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()){
            sb.append((char) bufferedReader.read());
        }
        String string = sb.toString();
        String[] strings = string.split("\\s");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].matches("[+-]?\\d+")) {
                bufferedWriter.write(strings[i] + " ");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
