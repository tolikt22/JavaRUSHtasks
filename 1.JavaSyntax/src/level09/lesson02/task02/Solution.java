package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его,
полученное с помощью StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static String method1()
    {
        method2();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        return (elements[2].getMethodName());

    }

    public static String method2()
    {
        method3();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        return (elements[2].getMethodName());

    }

    public static String method3()
    {
        method4();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        return (elements[2].getMethodName());

    }

    public static String method4()
    {
        method5();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        return (elements[2].getMethodName());

    }

    public static String method5()
    {
      StackTraceElement[] elements = Thread.currentThread().getStackTrace();
      return (elements[2].getMethodName());
    }
}
    /*Как я понял, запись в массив методов идет с начала массива.
    Поэтому 0й элемент это сам getStackTrace(), 1й - метод, вызвавший getStackTrace(),
    2й - метод, вызывавший метод, вызвавший getStackTrace(). Он нам и нужен по условию
    как "метод должен возвращать имя метода, вызвавшего его". А без цифры не получается,
    потому что StackTraceElement[] stackTraceElements - это массив размером в количество методов,
    полученных с помощью getStackTrace(). Я сначала не понял, что создается массив,
    и решил задачу создав ArrayList, for each'ем записал туда все методы и уже из него вернул 2ю ячейку.
     Сервер принял данное решение. Но я подумал, что явно можно проще ))*/