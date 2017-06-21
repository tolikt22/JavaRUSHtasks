package com.javarush.task.task14.task1408;

/**
 * Created by tolik on 20.06.2017.
 */
class BelarusianHen extends Hen implements Country {

    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
