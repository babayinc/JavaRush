package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ukr-maksimyak on 11.03.2015.
 */
public class BelarusianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 27;
    }

    public String getDescription()
    {

        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";


    }
}
