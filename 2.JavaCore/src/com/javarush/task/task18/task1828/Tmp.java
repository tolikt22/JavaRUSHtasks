package com.javarush.task.task18.task1828;

/**
 * Created by tolik on 01.10.2017.
 */
public class Tmp {
    public static void main(String[] args) {
        String d = "8767";
        String s = String.format("%1$-" + 8 + "s", d);
        System.out.println(s+"_");
    }
}
