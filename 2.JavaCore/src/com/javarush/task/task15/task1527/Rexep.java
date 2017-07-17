package com.javarush.task.task15.task1527;
public class Rexep {

    public static final String TEXT = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";

    public static void main(String[] args){

        System.out.println(TEXT.replaceAll("[Тт]а[ий]ланд","Україна"));

    }

}
