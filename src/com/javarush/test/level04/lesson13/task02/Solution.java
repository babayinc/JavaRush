package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sn = bufferedReader.readLine();
        String sm = bufferedReader.readLine();
        int n = Integer.parseInt(sn);
        int m = Integer.parseInt(sm);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print("8");
            System.out.println();
        }


    }
}
