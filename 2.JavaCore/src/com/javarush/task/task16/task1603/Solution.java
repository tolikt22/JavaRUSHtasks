package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread spThread = new SpecialThread();
        SpecialThread spThread1 = new SpecialThread();
        SpecialThread spThread2 = new SpecialThread();
        SpecialThread spThread3 = new SpecialThread();
        SpecialThread spThread4 = new SpecialThread();

        Thread thread = new Thread(spThread);
        Thread thread1 = new Thread(spThread1);
        Thread thread2 = new Thread(spThread2);
        Thread thread3 = new Thread(spThread3);
        Thread thread4 = new Thread(spThread4);

        list.add(thread);
        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).start();
//        }
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
