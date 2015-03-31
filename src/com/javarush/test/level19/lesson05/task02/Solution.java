package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readfile = new BufferedReader(new FileReader(reader.readLine()));
        int count = 0;
        while (readfile.ready())
        {
            String[] s = readfile.readLine().replaceAll("\\p{Punct}"," ").split(" ");
            for (String u : s)
            {
                if ("world".equals(u)) count++;
            }
        }
        System.out.println(count);
    }
}
