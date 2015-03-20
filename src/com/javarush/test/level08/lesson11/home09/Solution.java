package com.javarush.test.level08.lesson11.home09;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/


import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("MAY 15 2014"));
        System.out.println(isDateOdd("MAY 26 2014"));
        System.out.println(isDateOdd("MAY 17 2014"));

    }

    public static boolean isDateOdd(String date)
    {
        Date startDate = new Date();
        startDate.setDate(1);
        startDate.setMonth(0);

        Date curentDate = new Date(date);

        long msTimeDistance = curentDate.getTime() - startDate.getTime();

        long msDay = 24 * 60 * 60 * 1000;

        int day = (int) (msTimeDistance / msDay);

        return (day % 2 == 0);
    }
}