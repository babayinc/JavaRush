package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[5];
        for (int i = 0; i < 5; i++) {
            n[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < 5; i++) {
            int min = 1000000000;
            for (int j = 0; j < 5; j++) {
                min = (min < n[j]) ? min : n[j];
            }
            for (int j = 0; j < 5; j++) {
                if (n[j] == min)
                    n[j] = 1000000000;
            }
            System.out.println(min);
        }
    }
}
