package com.javarush.task.task19.task1906;

import java.io.*;

/*
Четные символы
        Считать с консоли 2 имени файла.
        Вывести во второй файл все символы с четным индексом.

        Пример:
        второй символ, четвертый символ, шестой символ и т.д.

        Закрыть потоки ввода-вывод

        Требования:
        1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
        2. BufferedReader для считывания данных с консоли должен быть закрыт.
        3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
        4. Поток чтения из файла (FileReader) должен быть закрыт.
        5. Программа должна записывать во второй файл все байты из первого файла с четным индексом (используй FileWriter).
        6. Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader fReader = new FileReader(fileName1);
        FileWriter fWriter = new FileWriter(fileName2);
        int count = 1;
        while (fReader.ready()) {
            int i = fReader.read();
            if (count % 2 == 0) {
                fWriter.write(i);
            }
            count++;
        }
        fReader.close();
        fWriter.close();
    }
}
