package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int n = 0;
        String sn = "";
        while (!sn.equals("сумма")){
            sn = bufferedReader.readLine();
            if (!sn.equals("сумма")){
                n = Integer.parseInt(sn);
                sum = sum + n;
            }
        }
        System.out.println(sum);
    }
}
