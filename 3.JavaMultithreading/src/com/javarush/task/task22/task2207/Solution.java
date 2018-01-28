package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    public static List<String> words = new ArrayList<>();
    private static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        BufferedReader readerFromFile = new BufferedReader(new InputStreamReader(fis));

        while ((line = readerFromFile.readLine()) != null) {
            String[] strings = line.split(" ");
            Collections.addAll(words, strings);
        }
        reader.close();
        fis.close();
        readerFromFile.close();

        for (int i = 0; i < words.size(); i++) {
            StringBuilder checkWord = new StringBuilder(words.get(i));
            for (int j = 0; j < words.size(); j++) {
                StringBuilder other = new StringBuilder(words.get(j));
                if (checkWord.toString().equals(other.reverse().toString()) && i != j) {
                    Pair pair = new Pair();
                    pair.first = other.reverse().toString();
                    pair.second = checkWord.toString();
                    result.add(pair);
                    words.remove(words.get(i));
                }
            }
        }
//        System.out.println(Arrays.toString(words.toArray()));
for (Pair pair : result) System.out.println(pair);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
