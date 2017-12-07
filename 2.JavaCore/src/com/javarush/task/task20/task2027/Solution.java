package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        detectAllWords(crossword, "home", "same");
//        System.out.println(Arrays.toString(detectAllWords(crossword, "home", "same", "kerpo","fsgrj","plgml","eroo","hrrp").toArray()));
        System.out.println(Arrays.toString(detectAllWords(crossword, "e").toArray()));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        String[] w = words;                                  // список слов в стринговый массив
        Word oneWord;
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {                 //перебираем по слову
            String word = w[i];
            for (int j = 1; j <= 8; j++) {                   // in 8 directions
                oneWord = findWord(crossword, word, j);
                if (oneWord != null) wordList.add(oneWord);
            }

        }
        return wordList;
    }

    private static Word findWord(int[][] crossword, String w, int direction) { //1 word in 1 direction
        char[] word = w.toCharArray();                                         // parsing String word to char[]
        Word oneWord = null;


        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if (crossword[i][j] == word[0]) {              //если первая буква слова совпадает c координатой массива
                    oneWord = detectDirections(j, i, word, crossword, direction);//отправляем на проверку по 1 направлению
                }
            }
        }
        return oneWord;  // возвращаем найденное слово или null
    }

    private static Word detectDirections(int x, int y, char[] word, int[][] crossword, int direction) {//ищем слово в 1 напр.
        StringBuilder wordString = new StringBuilder();
        Word foundWord = null;
        int startX = x, startY = y;
        int endX, endY;
        int count = 0;   //matching chars counter
        int charCount = 0; //in word chars counter
        while (y >= 0 && x >= 0 && y < crossword.length && x < crossword[0].length && charCount < word.length) {    //keeping array borders
            if (word[charCount] == crossword[y][x]) { // !!
                wordString.append(word[charCount]);
                count++;
            }
            if (count == word.length) {
                endX = x;
                endY = y;
                foundWord = new Word(wordString.toString());
                foundWord.setStartPoint(startX, startY);
                foundWord.setEndPoint(endX, endY);
            }
            charCount++;

            switch (direction) {  //moving in the direction indicated
                case 1:
                    x++;
                    break;
                case 2:
                    x++;
                    y--;
                    break;
                case 3:
                    y--;
                    break;
                case 4:
                    y--;
                    x--;
                    break;
                case 5:
                    x--;
                    break;
                case 6:
                    x--;
                    y++;
                    break;
                case 7:
                    y++;
                    break;
                case 8:
                    y++;
                    x++;
                    break;
            }
        }
        return foundWord;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}