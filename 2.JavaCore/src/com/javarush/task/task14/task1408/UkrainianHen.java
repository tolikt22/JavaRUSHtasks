package com.javarush.task.task14.task1408;

/**
 * Created by tolik on 20.06.2017.
 */
class UkrainianHen extends Hen implements Country {

    @Override
    int getCountOfEggsPerMonth() {
        return 4;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
