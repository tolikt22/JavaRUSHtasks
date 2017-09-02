package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new Endless()));
        threads.add(new Thread(new InterruptedThread()));
        threads.add(new Thread(new Hura()));
        threads.add(new ShowMessage());
        threads.add(new Thread(new Counter()));

//        for (int i = 0; i < threads.size(); i++) {
//            threads.get(i).start();
//        }
    }

    public static void main(String[] args) {
        threads.get(3).start();

    }

    public static class Endless implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class InterruptedThread implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Hura implements Runnable {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ShowMessage extends Thread implements Message {
        public void run() {
            while (Thread.currentThread().isAlive()) {
                showWarning();
            }
        }

        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Counter implements Runnable {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            int sum = 0;
            try {
                while (!(s = reader.readLine()).equals("N")) {
                    if (isDigit(s))
                        sum = sum + Integer.parseInt(s);
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static boolean isDigit(String s) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}