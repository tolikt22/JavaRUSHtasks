package com.javarush.task.task19.task1907;

/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);

        StringBuilder sb = new StringBuilder();
        String string;
        int matchCounter = 0;
        while (fileReader.ready()) {
            sb.append((char) fileReader.read());
        }
        fileReader.close();
        string = sb.toString();

        String regExp = "\\bworld\\b";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            matchCounter++;
        }
        System.out.println(matchCounter);
    }
}