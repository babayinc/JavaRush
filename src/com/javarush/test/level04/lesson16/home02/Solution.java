package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sn0 = bufferedReader.readLine();
        String sn1 = bufferedReader.readLine();
        String sn2 = bufferedReader.readLine();
        int n0 = Integer.parseInt(sn0);
        int n1 = Integer.parseInt(sn1);
        int n2 = Integer.parseInt(sn2);

        int min;
        if (n0 < n1)
            min = n0;
        else
            min = n1;
        if (min > n2)
            min = n2;
        int max;
        if (n0 < n1)
            max = n1;
        else
            max = n0;
        if (max < n2)
            max = n2;
        if (n0 != max && n0 != min)
            System.out.println(n0);
        if (n1 != max && n1 != min)
            System.out.println(n1);
        if (n2 != max && n2 != min)
            System.out.println(n2);

    }
}
