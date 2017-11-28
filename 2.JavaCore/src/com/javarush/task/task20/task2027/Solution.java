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
        System.out.println(Arrays.toString(detectAllWords(crossword, "home", "same").toArray()));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        String[] w = words;
        Word oneWord;
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            String word = w[0];
            oneWord = findWord(crossword, word);
            if (!oneWord.equals(null)) wordList.add(oneWord);
        }
        return wordList;
    }

    private static Word findWord(int[][] crossword, String w) {
        char[] word = w.toCharArray();
        Word oneWord = null;


        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if (crossword[i][j] == word[0]) {
                    oneWord = detectDirections(i, j, word, crossword);
                }
            }
        }
        return oneWord;
    }

    private static Word detectDirections(int x, int y, char[] word, int[][] crossword) {
        StringBuilder wordString = null;
        Word foundWord = null;
        int startX = x, startY = y;
        int endX, endY;
        int count = 0;
        while (x >= 0 && y >= 0 && x < crossword.length && y < crossword[0].length) {
            for (int i = 0; i < word.length; i++) {
                x++;
                if (word[i] == crossword[x][y]) {
                    wordString.append(word[i]);
                }
                if (count == word.length) {
                    endX = x;
                    endY = y;
                    foundWord = new Word(wordString.toString());
                    foundWord.setStartPoint(startX, startY);
                    foundWord.setEndPoint(endX, endY);
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
