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
        System.out.println(Arrays.toString(detectAllWords(crossword, "home", "same", "kerpo", "fsgrj", "plgml", "prek", "hrrp", "e").toArray()));
//        System.out.println(Arrays.toString(detectAllWords(crossword, "ngrov").toArray()));
//        System.out.println(Arrays.toString(detectAllWords(crossword, "lngrov").toArray()));
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
        for (int k = 0; k < w.length; k++) {                 //перебираем по слову
            String word = w[k];
            char[] chars = word.toCharArray();                                         // parsing String word to char[]
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == chars[0]) {              //если первая буква слова совпадает c координатой массива
                        oneWord = detectDirections(j, i, chars, crossword);//отправляем на проверку по 8 направл.
                        if (oneWord != null && word.length() != 1) {
                            wordList.add(oneWord);
                        }
                    }
                }
            }
        }
        return wordList;
    }

    private static Word detectDirections(int x, int y, char[] word, int[][] crossword) {//ищем слово во всех напр.
        StringBuilder wordString = new StringBuilder();
        Word foundWord = null;
        int tmpX = x, tmpY = y;
        int startX = tmpX, startY = tmpY;

        for (int direction = 1; direction <= 8; direction++) {
            int endX, endY;
            int count = 0;   //matching chars counter
            int charCount = 0; //in word chars counter
            x=tmpX;y= tmpY;
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
//                    return foundWord;
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