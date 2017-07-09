package com.javarush.task.task15.task1522;

/**
 * Created by tolik on 09.07.2017.
 */
public class Earth implements Planet {
    private Earth() {
    }

    private static Earth instance;

    public static Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}
