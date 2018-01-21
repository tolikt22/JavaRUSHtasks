package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horseList = new ArrayList<Horse>();
        horseList.add(new Horse("Thunder", 3, 0));
        horseList.add(new Horse("Arrow", 3, 0));
        horseList.add(new Horse("Flash", 3, 0));
        game = new Hippodrome(horseList);
        game.run();
        game.printWinner();
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(20);
        }
    }

    void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        return horses.stream().max(Comparator.comparingDouble(Horse::getDistance)).get();
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+"!");
    }
}
