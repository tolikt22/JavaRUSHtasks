package com.javarush.task.task14.task1417;

/**
 * Created by tolik on 28.06.2017.
 */
public class Ruble extends Money {
    public Ruble(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
