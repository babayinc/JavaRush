package com.javarush.test.level14.lesson08.home09;

/**
 * Created by ukr-maksimyak on 13.03.2015.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
