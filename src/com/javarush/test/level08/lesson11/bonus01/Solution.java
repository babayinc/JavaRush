package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String month = bufferedReader.readLine();
        DateFormat dateFormat = new SimpleDateFormat("MMM", Locale.ENGLISH);

        try
        {
            Date date = dateFormat.parse(month);
            System.out.println(month + " is " + (int)(date.getMonth() + 1) + " month");
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

}
