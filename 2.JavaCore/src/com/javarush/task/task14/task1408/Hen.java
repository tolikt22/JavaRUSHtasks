package com.javarush.task.task14.task1408;

/**
 * Created by tolik on 20.06.2017.
 */
abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    String getDescription() {
        return "Я - курица.";
    }
}
