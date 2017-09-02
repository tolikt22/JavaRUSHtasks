package com.javarush.task.task13.task1308;

/* 
Жив или нет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
    public interface Person{
        static boolean isAlive() {
            return false;
        }
    }
    public interface Presentable extends Person{

    }
}